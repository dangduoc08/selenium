package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HrmAdminPage {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String URL = "https://opensource-demo.orangehrmlive.com/";

        try {
            driver.get(URL);

            driver.quit();
        } catch (Exception e) {
            System.out.println("[ERROR]" + e);
            driver.quit();
        }
    }
}
