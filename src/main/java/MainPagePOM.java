import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPagePOM {
    private WebDriver driver;
    private By orderButtonHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]"); //Кнопка заказа наверху
    private By orderButtonBottom = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"); //Кнопка заказа пониже
    private By statusButton = By.className("Header_Link__1TAG7"); //Кнопка "статус заказа"
    private By logoYandex = By.className("Header_LogoYandex__3TSOI"); //Логотип яндекса
    private By logoScooter = By.className("Header_LogoScooter__3lsAR"); //Логотип самокатов

    public MainPagePOM(WebDriver driver) {
        this.driver = driver;
    }

    public void orderButtonHeaderClick() {
        driver.findElement(orderButtonHeader).click();
    }

    public void orderButtonBottomClick() {
        driver.findElement(orderButtonBottom).click();
    }

    public void statusButtonClick() {
        driver.findElement(statusButton).click();
    }

    public void logoYandexClick() {
        driver.findElement(logoYandex).click();
    }

    public void logoScooterClick() {
        driver.findElement(logoScooter).click();
    }

    public void faqTabClick(int index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));//Использован скрипт из-за неясного поведения /assets/scooter.png
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); //При нескольких запусках одного и того же кода он мог как перекрыть кнопку, так и нет.
    }

    public String faqTabGetText(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + index)));
        return driver.findElement(By.id("accordion__panel-" + index)).getText();
    }

    public void scrollToFaqTab(int index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //Скролл вместо закрытия окна с куками выглядит надёжнее.
    }
}

