package by.bsu.at.dmitrylishko.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageAndRegion {
    private WebDriver driver;

    public LanguageAndRegion(WebDriver driver) {
        this.driver = driver;
    }

    public void openLanguageSelector() {
        driver.findElement(By.className("header-lang-info")).click();
    }

    public void changeRegion() {
        driver.findElements(By.cssSelector("ul.list-tooltip>li")).get(1).click();
    }
}
