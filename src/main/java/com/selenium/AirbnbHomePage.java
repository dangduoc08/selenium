package com.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirbnbHomePage {

    static WebDriver chromeDriver;

    public static WebElement findMenuItemByText(String text) {
        try {
            String xpathQuery = String.format("//ul[contains(@class, 'menu-phone')]//li[a[normalize-space(text())='%s']]", text);
            System.out.println(String.format("By.xpath(\"%s\")", xpathQuery));

            return AirbnbHomePage.chromeDriver.findElement(By.xpath(xpathQuery));
        } catch (Exception e) {
            System.out.println("[ERROR] - findMenuItemByText" + e);
            return null;
        }
    }

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        AirbnbHomePage.chromeDriver = driver;

        final String URL = "https://demo4.cybersoft.edu.vn/";
        final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

        try {
            driver.get(URL);

            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);

            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));

            String xpath1 = "//a[./img[@alt=\"Airbnb Logo\"]]";
            driver.findElement(By.xpath(xpath1));
            System.out.println(String.format("Locator 1: By.xpath(\"%s\")", xpath1));

            System.out.print("Locator 2: ");
            AirbnbHomePage.findMenuItemByText("Home");

            System.out.print("Locator 3: ");
            AirbnbHomePage.findMenuItemByText("About");

            String xpath4 = "//button[./img[@class='h-10']]";
            driver.findElement(By.xpath(xpath4));
            System.out.println(String.format("Locator 4: By.xpath(\"%s\")", xpath4));

            String xpath5 = "//div[contains(@class, 'container')]/div/div[./p[text()='Địa điểm']]";
            driver.findElement(By.xpath(xpath5));
            System.out.println(String.format("Locator 5: By.xpath(\"%s\")", xpath5));

            String xpath6 = "//div[contains(@class, 'container')]/div/div[./p[contains(text(), '/') or contains(normalize-space(text()), '-')]]";
            driver.findElement(By.xpath(xpath6));
            System.out.println(String.format("Locator 6: By.xpath(\"%s\")", xpath6));

            // date
            String xpath7 = "//div[contains(@class, 'container')]/div/div[./p[text()='Thêm khách']]";
            WebElement addCustomerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath7)));
            System.out.println(String.format("Locator 7: By.xpath(\"%s\")", xpath7));

            if (addCustomerBtn != null) {
                addCustomerBtn.click();
            }

            String xpath8 = "//button[div[text()='+']]";
            WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath8)));
            System.out.println(String.format("Locator 8: By.xpath(\"%s\")", xpath8));
            plusBtn.click();
            plusBtn.click();

            Thread.sleep(DEFAULT_WAIT);
            System.out.println("[DONE] - project 2");
            driver.quit();
        } catch (Exception e) {
            System.out.println("[ERROR] - project 2" + e);
            driver.quit();
        }
    }
}
