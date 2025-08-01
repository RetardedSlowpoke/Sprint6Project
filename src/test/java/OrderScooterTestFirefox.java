import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderScooterTestFirefox

{
    private WebDriver driver;
    @BeforeEach
    public void browserStartAndOpenPage()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments ("--headless");

        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Иван, Иванов, Ленинский проспект 123, Ленинск, +78005553535, 25.08.2025, двое суток, black, Комментарий для курьера",
            "Петр, Петров, Первомайская 22, Первома, +79123456789, 29.09.2025, шестеро суток, grey, Другой комментарий" //Хотел сначала не заполнять строку, но решил что усложню слишком сильно, и так путаюсь уже.
    })
    public void orderParameterizedTest(String name, String surname, String address, String station, String number, String date, String period, String color, String comment){

        OrderPagePOM orderPagePOM = new OrderPagePOM(driver);


        orderPagePOM.nameFieldClickAndFill(name); //Выделили и заполнили имя.

        orderPagePOM.surnameFieldClickAndFill(surname); //Фамилию

        orderPagePOM.addressFieldClickAndFill(address);//Адрес

        orderPagePOM.stationFieldClickAndFill(station);//Метро

        orderPagePOM.numberFieldClickAndFill(number); //Номер

        orderPagePOM.continueButtonClick(); //Дальше.
//Вторая страничка
        orderPagePOM.dateFieldClickAndFill(date); //"Когда привезти..."

        orderPagePOM.periodFieldClickAndFill(period);//Выбираем на сколько

        orderPagePOM.setColor(color); //устанавливаем цвет

        orderPagePOM.commentFieldClickAndFill(comment);//пишем комментарий

        orderPagePOM.orderButtonClick(); //Жмём нижнюю "заказать"
        orderPagePOM.confirmClick(); //Тыкаем на "Да".

        String successText = driver.findElement(By.className("Order_Text__2broi")).getText();

        assertTrue(successText.contains("Номер заказа"), "Окно подтверждения заказа не выскочило"); //А в Firefox всё ок.
    }

    @AfterEach
    public void browserQuit() {

       driver.quit();
    }
}
