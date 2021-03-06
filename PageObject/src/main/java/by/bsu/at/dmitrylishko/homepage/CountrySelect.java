package by.bsu.at.dmitrylishko.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountrySelect {
    private WebDriver driver;

    public CountrySelect(WebDriver driver) {
        this.driver = driver;
    }

    public void setCountry(String country){
        driver.findElement(By.partialLinkText(country)).click();
    }

    public void setLanguage(String language) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(language))));
        driver.findElement(By.partialLinkText(language)).click();
    }
}
