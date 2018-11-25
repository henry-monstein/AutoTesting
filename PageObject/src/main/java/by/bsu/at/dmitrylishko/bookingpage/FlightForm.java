package by.bsu.at.dmitrylishko.bookingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightForm {
    private WebDriver driver;
    private List<WebElement> plusMinus;

    public FlightForm(WebDriver driver) {
        this.driver = driver;

    }

    public void setDeparture(String from) {
        driver.findElement(By.id("autoCompDest_dep0")).sendKeys(from);
    }

    public void setArrival(String to) {
        driver.findElement(By.id("autoCompDest_arr0")).sendKeys(to);
    }

    public void clickSubmit(String next) {
        driver.findElement(By.id("button_" + next)).click();
    }

    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    public void removeAdult() {
        clickMinus(0);
    }

    public void addAdult() {
        clickPlus(0);
    }

    public void addChild() {
        clickPlus(1);
    }

    public void addBaby() {
        clickPlus(2);
    }

    private void clickPlus(int ageGroup) {
        setPlusMinus();
        plusMinus.get(ageGroup * 2 + 1).click();
    }

    private void clickMinus(int ageGroup) {
        setPlusMinus();
        plusMinus.get(ageGroup * 2).click();
    }

    private void setPlusMinus() {
        plusMinus = driver.findElements(By.cssSelector("div.plus_minus>a"));
    }

    public void openSaleLocations() {
        driver.findElement(By.className("sw-placeholder")).click();
    }

    public void setSaleLocation(String location) {
        List<WebElement> saleLocations = driver.findElements(By.cssSelector("div.opened>ul>li"));
        for (WebElement saleLocation : saleLocations) {
            if (saleLocation.getAttribute("data-value").equals(location)) {
                saleLocation.click();
                break;
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickCalendar(int i) {
        driver.findElement(By.id("fsfCalendar" + i)).click();
        sleep();
    }

    public void setDepartureDate(int date) {
        driver.findElement(By.cssSelector("div.ui-datepicker-next>a")).click();
        driver.findElement(By.partialLinkText(String.valueOf(date))).click();
    }

    public boolean isPrivousDataUnselectable(int date) {
        List<WebElement> list = driver.findElements(By.className("ui-datepicker-unselectable"));
        boolean flag = false;
        for (WebElement el : list) {
            if (el.getText().equals(String.valueOf(date - 1))) {
                flag = true;
            }

        }
        return flag;
    }

    public void oneWay() {
        driver.findElement(By.id("journeyTypeOW2")).click();
    }

    public String getDiffCurrency() {
        return driver.findElement(By.className("diff_currency")).getText();
    }

    public void setFlight() {
        driver.findElement(By.className("description")).click();
    }

    public void setRate(String rate) {
        driver.findElement(By.className(rate)).click();
        sleep();
    }

    public double getTotalPrice() {
        return Double.valueOf(driver.findElement(By.id("totalAmount2")).getText().split(" ")[0]);
    }
}
