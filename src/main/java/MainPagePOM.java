import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPagePOM {
    private WebDriver driver;

    public MainPagePOM(WebDriver driver) {
        this.driver = driver;
    }

   //Раньше тут были локаторы разных кнопок "заказать". Сейчас остался один.
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private By statusButton = By.className("Header_Link__1TAG7"); //Кнопка "статус заказа"
    private By logoYandex = By.xpath("//img[@alt='Yandex']");//Логотип яндекса
    private By logoScooter = By.className("Header_LogoScooter__3lsAR"); //Логотип самокатов
    private By cookieButton = By.className("App_CookieButton__3cvqF"); //Кнопка принятия куки.



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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void cookieButtonAcceptClick()
    {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButtonByXpath(String xpath) {
        cookieButtonAcceptClick();
        driver.findElement(By.xpath(xpath)).click();
    }

}

