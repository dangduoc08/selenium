package com.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HrmAdminPage {

    static WebDriver chromeDriver;

    public static WebElement findMenuItemByText(String text) {
        try {
            String xpathQuery = String.format("//ul[@class='oxd-main-menu']/li/a/span[text()='%s']", text);
            System.out.println(String.format("By.xpath(\"%s\")", xpathQuery));

            return HrmAdminPage.chromeDriver.findElement(By.xpath(xpathQuery));
        } catch (Exception e) {
            System.out.println("[ERROR] - findMenuItemByText" + e);
            return null;
        }
    }

    public static WebElement findButtonByText(String text) {
        try {
            String xpathQuery = String.format("//button[normalize-space(.)='%s']", text);
            System.out.println(String.format("By.xpath(\"%s\")", xpathQuery));

            return HrmAdminPage.chromeDriver.findElement(By.xpath(xpathQuery));
        } catch (Exception e) {
            System.out.println("[ERROR] - findButtonByText" + e);
            return null;
        }
    }

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        HrmAdminPage.chromeDriver = driver;

        final String URL = "https://opensource-demo.orangehrmlive.com/";
        final String USER = "Admin";
        final String PWD = "admin123";
        final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

        try {
            driver.get(URL);

            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

            if (submitButton != null) {
                WebElement usernameInput = driver.findElement(By.name("username"));
                WebElement passwordInput = driver.findElement(By.name("password"));

                usernameInput.sendKeys(USER);
                passwordInput.sendKeys(PWD);

                submitButton.click();
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu")));

            System.out.print("Locator 1: ");
            WebElement adminItem = HrmAdminPage.findMenuItemByText("Admin");

            System.out.print("Locator 2: ");
            HrmAdminPage.findMenuItemByText("PIM");

            System.out.print("Locator 3: ");
            HrmAdminPage.findMenuItemByText("Leave");

            if (adminItem != null) {
                adminItem.click();
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-background-container")));

            String xpath4 = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']";
            WebElement usernameSearch = driver.findElement(By.xpath(xpath4));
            usernameSearch.sendKeys("Username search test");
            System.out.println(String.format("Locator 4: By.xpath(\"%s\")", xpath4));

            String xpath5 = "//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')][div//label[text()='User Role']]//div[@tabindex='0']";
            WebElement useRoleDropdown = driver.findElement(By.xpath(xpath5));
            useRoleDropdown.click();
            System.out.println(String.format("Locator 5: By.xpath(\"%s\")", xpath5));

            String xpath6 = "//div[span[text()='Admin']]";
            useRoleDropdown.findElement(By.xpath(xpath6));
            System.out.println(String.format("Locator 6: By.xpath(\"%s\")", xpath6));

            String xpath7 = "//div[span[text()='ESS']]";
            WebElement essOption = useRoleDropdown.findElement(By.xpath(xpath7));
            if (essOption != null) {
                essOption.click();
            }
            System.out.println(String.format("Locator 7: By.xpath(\"%s\")", xpath7));

            String xpath8 = "//div[contains(@class, 'oxd-input-group oxd-input-field-bottom-space')][div[label[text()= 'Employee Name']]]//input";
            WebElement employeeNameSearch = driver.findElement(By.xpath(xpath8));
            employeeNameSearch.sendKeys("Employee name search test");
            System.out.println(String.format("Locator 8: By.xpath(\"%s\")", xpath8));

            System.out.print("Locator 9: ");
            HrmAdminPage.findButtonByText("Reset");

            System.out.print("Locator 10: ");
            HrmAdminPage.findButtonByText("Search");

            String xpath11 = "//li[span[@class='oxd-topbar-body-nav-tab-item' and normalize-space(text())='User Management']]";
            WebElement userManagementMenuItem = useRoleDropdown.findElement(By.xpath(xpath11));
            if (userManagementMenuItem != null) {
                userManagementMenuItem.click();
            }
            System.out.println(String.format("Locator 11: By.xpath(\"%s\")", xpath11));

            String xpath12 = "(//div[@class='oxd-table-card'])[1]//div[2]";
            driver.findElement(By.xpath(xpath12));
            System.out.println(String.format("Locator 12: By.xpath(\"%s\")", xpath12));

            String xpath13 = "(//div[@class='oxd-table-card'])[1]//div[3]";
            driver.findElement(By.xpath(xpath13));
            System.out.println(String.format("Locator 13: By.xpath(\"%s\")", xpath13));

            String xpath14 = "(//div[@class='oxd-table-card'])[1]//div[6]//button[i[contains(@class, 'oxd-icon bi-trash')]]";
            driver.findElement(By.xpath(xpath14));
            System.out.println(String.format("Locator 14: By.xpath(\"%s\")", xpath14));

            String xpath15 = "(//div[@class='oxd-table-card'])[1]//div[6]//button[i[contains(@class, 'bi-pencil-fill')]]";
            driver.findElement(By.xpath(xpath15));
            System.out.println(String.format("Locator 15: By.xpath(\"%s\")", xpath15));

            String xpath16 = "//div[@role=\"columnheader\" and text()='User Role']";
            driver.findElement(By.xpath(xpath16));
            System.out.println(String.format("Locator 16: By.xpath(\"%s\")", xpath16));

            String xpath17 = "//div[@role=\"columnheader\" and text()='Employee Name']";
            driver.findElement(By.xpath(xpath17));
            System.out.println(String.format("Locator 17: By.xpath(\"%s\")", xpath17));

            String xpath18 = "//h6[normalize-space(.)='User Management']";
            driver.findElement(By.xpath(xpath18));
            System.out.println(String.format("Locator 18: By.xpath(\"%s\")", xpath18));

            String xpath19 = "//button[./i[contains(@class, 'bi-chevron-left')]]";
            WebElement toggleSidebarButton = driver.findElement(By.xpath(xpath19));
            if (toggleSidebarButton != null) {
                toggleSidebarButton.click();
            }
            System.out.println(String.format("Locator 19: By.xpath(\"%s\")", xpath19));

            String xpath20 = "//button[./i[contains(@class, 'bi-caret-up-fill')]]";
            WebElement toggleToolbarButton = driver.findElement(By.xpath(xpath20));
            if (toggleToolbarButton != null) {
                toggleToolbarButton.click();
            }
            System.out.println(String.format("Locator 20: By.xpath(\"%s\")", xpath20));

            Thread.sleep(DEFAULT_WAIT);
            System.out.println("[DONE] - project 1");
            driver.quit();
        } catch (Exception e) {
            System.out.println("[ERROR] - project 1" + e);
            driver.quit();
        }
    }
}
