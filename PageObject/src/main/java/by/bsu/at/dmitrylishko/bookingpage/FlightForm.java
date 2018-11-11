package by.bsu.at.dmitrylishko.bookingpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightForm {
    private WebDriver driver;
    private WebElement departure;
    private WebElement arrival;
    private WebElement submitButton;
    private Alert alert;
    private List<WebElement> plusMinus;
    private List<WebElement> saleLocations;
    private WebElement way;

    public FlightForm(WebDriver driver) {
        this.driver = driver;

    }

    public void setDeparture(String from) {
        departure = driver.findElement(By.id("autoCompDest_dep0"));
        departure.sendKeys(from);
    }

    public void setArrival(String to) {
        arrival = driver.findElement(By.id("autoCompDest_arr0"));
        arrival.sendKeys(to);
    }

    public void clickSubmit(String next) {
        submitButton = driver.findElement(By.id("button_" + next));
        submitButton.click();
    }

    public String getTextAlert() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }
}
