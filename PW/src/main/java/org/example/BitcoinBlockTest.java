package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BitcoinBlockTest {
    protected WebDriver driver;
    protected final String url = "https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732";

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); // Set path to your ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        driver = new ChromeDriver(options);
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
