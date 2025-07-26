import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePOM {
    private WebDriver driver;
    private By orderButtonHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]"); //Кнопка заказа наверху
    private By orderButtonBottom = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"); //Кнопка заказа пониже
    private By statusButton = By.className("Header_Link__1TAG7"); //Кнопка "статус заказа"
    private By logoYandex = By.className("Header_LogoYandex__3TSOI"); //Логотип яндекса
    private By logoScooter = By.className("Header_LogoScooter__3lsAR"); //Логотип самокатов

    public MainPagePOM (WebDriver driver){
        this.driver = driver;
    }
    public void orderButtonHeaderClick(){
        driver.findElement(orderButtonHeader).click();
    }
    public void orderButtonBottomClick(){
        driver.findElement(orderButtonBottom).click();
    }
    public void statusButtonClick(){
        driver.findElement(statusButton).click();
    }
    public void logoYandexClick(){
        driver.findElement(logoYandex).click();
    }
    public void logoScooterClick(){
        driver.findElement(logoScooter).click();
    }
    public void faqTabClick(int index){
        driver.findElement(By.id("accordion__heading-"+ index)).click();
    }
    public String faqTabHeaderGetText (int index){
        return driver.findElement(By.id("accordion__heading-"+ index)).getText();
    }
    public String faqTabGetText (int index){
        return driver.findElement(By.id("accordion__panel-"+ index)).getText();
    }
}
