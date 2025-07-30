import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private By continueButton = By.cssSelector (".Button_Button__ra12g.Button_Middle__1CSJM");
    //Вторая страничка
    private By dateField = By.xpath("*//input[@placeholder= '* Когда привезти самокат']"); //Когда
    private By periodField = By.className("Dropdown-placeholder");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); //Комментарий
    private By orderButton = By.xpath("(//button[text()='Заказать'])[2]"); //Хитрая кнопка "заказать" же ещё и сверху есть. А мне вторая нужна... Завершаем заказ.
    private By confirmButton = By.xpath("(//button[text()='Да'])");

    public void nameFieldClick (){ //
        driver.findElement(nameField).click();
    }
    public void surnameFieldClick(){
        driver.findElement(surnameField);
    }
    public void addressFieldClick(){
        driver.findElement(addressField);
    }
    public void stationFieldClick(){
        driver.findElement(stationField);
    }
    public void numberFieldClick(){
        driver.findElement(numberField);
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setStation(String station) {
        driver.findElement(stationField).sendKeys(station);
        driver.findElement(By.xpath("//div[contains(text(),'" + station + "')]")).click(); //Пытаемся выбрать заданную станцию: как нормально разбираться с выпадающим списком не ясно, его же не заинспектить...
    }

    public void setPhoneNumber(String number) {
        driver.findElement(numberField).sendKeys(number);
    }
    public void continueButtonClick(){
        driver.findElement(continueButton).click();
    }
    public void dateFieldClick(){
        driver.findElement(dateField).click();
    }
    public void setDate(String date){
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER); //убираем датапикер
    }
    public void periodFieldClick(){
        driver.findElement(periodField).click();
    }
    public By periodFieldOptions (String option){
    return By.xpath("//div[@class='Dropdown-option' and text()='" + option + "']"); //ищем нужную опцию
    }
    public void setPeriod(String period){
        driver.findElement(periodFieldOptions(period)).click();
    }
    public void setColor(String colorId) {
        driver.findElement(By.id(colorId)).click();
    }
    public void commentFieldClick(){
        driver.findElement(commentField).click();
    }
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }
    public void confirmClick(){
        driver.findElement(confirmButton).click();
    }
}
