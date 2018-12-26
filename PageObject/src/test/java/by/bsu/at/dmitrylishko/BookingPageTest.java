package by.bsu.at.dmitrylishko;

import static org.junit.Assert.*;


import by.bsu.at.dmitrylishko.bookingpage.FlightForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookingPageTest {
    private WebDriver driver;
    private FlightForm form;

    @Before
    public void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://booking.csa.cz/en/ibs/index.php?");
        form = new FlightForm(driver);
    }

    @After
    public void tearDownChromeDriverQuit() {
        form = null;
        driver.quit();
    }

    @Test
    public void departureToTheSamePlaceTest() {
        form.setDeparture("PRG");
        form.setArrival("PRG");
        form.clickSubmit("next");
        String expectedErr = "Departing FROM and TO must be different!";
        assertEquals(expectedErr, form.getTextAlert());
    }

    @Test
    public void passengerAbsenceTest() {
        form.removeAdult();
        String expectedErr = "Please select passengers!";
        assertEquals(expectedErr, form.getTextAlert());
    }

    @Test
    public void babiesMoreThanAdultsTest() {
        form.addBaby();
        form.removeAdult();
        String expectedErr = "Number of infants cannot be higher then number of adult passengers!";
        assertEquals(expectedErr, form.getTextAlert());
    }

    @Test
    public void maximumNumberOfPassengersTest() {
        try {
            while (true) {
                form.addAdult();
                form.addChild();
            }
        } catch (UnhandledAlertException e) {
            String expectedErr = "Maximal number of passengers has been exceeded! " +
                    "Your booking can be made for maximum 9 passengers.";
            assertEquals(expectedErr, form.getTextAlert());

        }
    }

    @Test
    public void childCannotTravelAloneTest() {
        form.addChild();
        form.removeAdult();
        String expectedErr = "Children cannot travel alone!";
        assertEquals(expectedErr, form.getTextAlert());
    }

    @Test
    public void previousDataUnselectableTest() {
        form.clickCalendar(0);
        form.setDepartureDate(14);
        form.clickCalendar(1);
        assertTrue(form.isPrivousDataUnselectable(14));
    }

    @Test
    public void diffCurrencyTest() {
        form.setDeparture("PRG");
        form.setArrival("AMS");
        form.oneWay();
        form.openSaleLocations();
        form.setSaleLocation("RU");
        form.clickSubmit("next");
        String expectedCurrency = "RUB";
        assertEquals(expectedCurrency, form.getDiffCurrency());
    }

    @Test
    public void totalAmountChangingTest() {
        form.setDeparture("PRG");
        form.setArrival("AMS");
        form.oneWay();
        form.clickCalendar(0);
        form.setDepartureDate(14);
        form.openSaleLocations();
        form.setSaleLocation("DE");
        form.clickSubmit("next");
        form.setFlight();
        form.setRate("fp_standard");
        double a = form.getTotalPrice();
        form.setRate("fp_flexi");
        double b = form.getTotalPrice();
        assertNotEquals(a, b);
    }

    @Test
    public void emptyFinalFormTest() {
        form.setDeparture("PRG");
        form.setArrival("AMS");
        form.oneWay();
        form.clickCalendar(0);
        form.setDepartureDate(14);
        form.openSaleLocations();
        form.setSaleLocation("DE");
        form.clickSubmit("next");
        form.setFlight();
        form.setRate("fp_standard");
        form.clickSubmit("next");
        form.clickSubmit("next");
        form.clickSubmit("confirm");
        String expectedAlert = "Please fill in firstname for passenger number 1";
        assertEquals(expectedAlert, form.getTextAlert());
    }


}
