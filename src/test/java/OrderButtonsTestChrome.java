import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderButtonsTestChrome {
    private WebDriver driver;

    @BeforeEach
    public void browserStartAndOpenPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--guest", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
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

