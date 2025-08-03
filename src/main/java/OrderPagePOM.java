import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPagePOM
{
    private WebDriver driver;

    public OrderPagePOM(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.xpath("*//input[@placeholder= '* Имя']"); //поле "Имя".
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']"); //поле "Фамилия"
    private  By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); //Поле "Адрес"
    private By stationField = By.xpath("//input[@placeholder='* Станция метро']"); //Метро
    private By numberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); //Телефон
    private By continueButton = By.cssSelector (".Button_Button__ra12g.Button_Middle__1CSJM");;
    //Вторая страничка
    private By dateField = By.xpath("*//input[@placeholder= '* Когда привезти самокат']"); //Когда
    private By periodField = By.className("Dropdown-placeholder");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); //Комментарий
    private By orderButton = By.xpath("(//button[text()='Заказать'])[2]"); //Хитрая кнопка "заказать" же ещё и сверху есть. А мне вторая нужна... Завершаем заказ.
    private By confirmButton = By.xpath("(//button[text()='Да'])");

    public void nameFieldClickAndFill (String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    public void surnameFieldClickAndFill(String surname){
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void addressFieldClickAndFill(String address){
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
    }
    public void stationFieldClickAndFill(String station){
        driver.findElement(stationField).click();
        driver.findElement(stationField).sendKeys(station);
        driver.findElement(By.xpath("//div[contains(text(),'" + station + "')]")).click(); //Пытаемся выбрать заданную станцию: как нормально разбираться с выпадающим списком не ясно, его же не заинспектить...
    }
    public void numberFieldClickAndFill(String number){
        driver.findElement(numberField).click();
        driver.findElement(numberField).sendKeys(number);
    }

    public void continueButtonClick(){
        driver.findElement(continueButton).click();
    }
    public void dateFieldClickAndFill(String date){
        driver.findElement(dateField).click();
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER); //убираем датапикер
    }

    public void periodFieldClickAndFill(String period){
        driver.findElement(periodField).click();
        driver.findElement(periodFieldOptions(period)).click();
    }
    public By periodFieldOptions (String option){
    return By.xpath("//div[@class='Dropdown-option' and text()='" + option + "']"); //ищем нужную опцию... Не уверен, что это можно запихнуть в тот же метод. Или можно?
    }

    public void setColor(String colorId) {
        driver.findElement(By.id(colorId)).click();
    }
    public void commentFieldClickAndFill(String comment){
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
    }

    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }
    public void confirmClick(){
        driver.findElement(confirmButton).click();
    }
}
