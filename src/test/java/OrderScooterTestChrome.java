import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderScooterTestChrome extends BaseTest

{

    @ParameterizedTest
    @CsvSource(value = {
            "top, Иван, Иванов, Ленинский проспект 123, Ленинск,+78005553535, 25.08.2025, двое суток, black, Комментарий для курьера",
            "bot, Петр, Петров, Первомайская 22, Первома, +79123456789, 29.09.2025, шестеро суток, grey, Другой комментарий" //Хотел сначала не заполнять строку, но решил что усложню слишком сильно, и так путаюсь уже.
    })
    public void orderParameterizedTest(String position, String name, String surname, String address, String station, String number, String date, String period, String color, String comment){

        OrderPagePOM orderPagePOM = new OrderPagePOM(driver);
        MainPagePOM mainPagePOM = new MainPagePOM(driver);


        mainPagePOM.clickOrderButton(position); //Открываем страницу заказа: в первом сценарии по верхней кнопке, во второй по нижней.
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


        String successText = driver.findElement(By.className("Order_Text__2broi")).getText(); //Получаем текст из окошка которого тут не будет, хе-хе.

        assertTrue(successText.contains("Номер заказа"), "Окно подтверждения заказа не выскочило"); //Тот самый баг: в Chrome кнопка "Да" кликается, но ничего не делает.

    }

}
