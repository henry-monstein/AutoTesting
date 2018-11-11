package by.bsu.at.dmitrylishko;

import by.bsu.at.dmitrylishko.homepage.CountrySelect;
import by.bsu.at.dmitrylishko.homepage.LanguageAndRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomePageTest {
    private WebDriver driver;

    @Before
    public void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.csa.cz/by-en/");
    }

    @After
    public void tearDownChromeDriverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    public void changeRegionTest() {
        LanguageAndRegion lar = new LanguageAndRegion(driver);
        lar.openLanguageSelector();
        lar.changeRegion();
        CountrySelect cs = new CountrySelect(driver);
        cs.setCountry("Ukraine");
        cs.setLanguage("Russian");
        String currentUrl = "https://www.csa.cz/ua-ru/";
        assertEquals(currentUrl, driver.getCurrentUrl());
    }
}
