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
        driver = null;
    }

    @Test
    public void departureToTheSamePlaceTest() {
        form.setDeparture("PRG");
        form.setArrival("PRG");
        form.clickSubmit("next");
        String expectedErr = "Departing FROM and TO must be different!";
        assertEquals(expectedErr, form.getTextAlert());
    }
}
