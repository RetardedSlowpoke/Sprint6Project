import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderButtonsTestFirefox {
    private WebDriver driver;

    @BeforeEach
    public void browserStartAndOpenPage() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments ("--headless");

        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void HeaderOrderButtonTest(){
        MainPagePOM mainPagePOM = new MainPagePOM(driver);
        mainPagePOM.orderButtonHeaderClick();
        boolean actual = driver.findElement(By.className("Order_Header__BZXOb")).isDisplayed();
        assertTrue(actual, "Форма заказа не открылась.");

    }
    @Test
    public void BottomOrderButtonTest(){
        MainPagePOM mainPagePOM = new MainPagePOM(driver);
        mainPagePOM.scrollToBottomOrderButton();
        mainPagePOM.orderButtonBottomClick();
        boolean actual = driver.findElement(By.className("Order_Header__BZXOb")).isDisplayed();
        assertTrue(actual, "Форма заказа не открылась.");

    }
    @AfterEach
    public void browserQuit() {

        driver.quit();
    }
}

