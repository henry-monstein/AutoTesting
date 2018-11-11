package by.bsu.at.dmitrylishko.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountrySelect {
    private WebDriver driver;

    public CountrySelect(WebDriver driver) {
        this.driver = driver;
    }

    public void setCountry(String country){
        driver.findElement(By.partialLinkText(country)).click();
    }

    public void setLanguage(String language) {
        driver.findElement(By.partialLinkText(language)).click();
    }
}
