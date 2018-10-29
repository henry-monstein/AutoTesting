package cz.csa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomePage {
    private WebDriver driver;

    @Before
    public void setUpChromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.csa.cz/by-ru/");
    }

    @After
    public void tearDownChromeDriverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    public void changeRegionTest() {
        driver.findElement(By.className("header-lang-info")).click();
        driver.findElement(By.partialLinkText("Выбрать другую страну")).click();
        driver.findElement(By.partialLinkText("Germany")).click();
        driver.findElements(By.partialLinkText("German")).get(1).click();
        String currentUrl = "https://www.csa.cz/de-de/";
        assertEquals(currentUrl, driver.getCurrentUrl());
    }
}
