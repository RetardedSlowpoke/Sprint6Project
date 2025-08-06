
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTestChrome extends BaseTest {


    @ParameterizedTest
    @CsvSource(value = {
            "0| Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "1| Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "2| Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "3| Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "4| Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "5| Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "6| Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "7| Да, обязательно. Всем самокатов! И Москве, и Московской области."
    }, delimiter = '|') //Изменил разделитель, чтобы нормально считывались запятые в тексте.

    public void faqTabOpenAndCheckTest(int index, String expected) {
        MainPagePOM mainPagePOM = new MainPagePOM(driver);
        mainPagePOM.scrollToFaqTab(index);
        mainPagePOM.faqTabClick(index);
        String actual = mainPagePOM.faqTabGetText(index);
        assertEquals(expected, actual, "Текст не совпадает.");

    }

    @Test
    public void scooterButtonUrlTest() { //Доп. задание: клик по лого самоката.
        MainPagePOM mainPagePOM = new MainPagePOM(driver);
        mainPagePOM.logoScooterClick();
        String url = driver.getCurrentUrl();
        assertEquals("https://qa-scooter.praktikum-services.ru/", url, "Адрес не совпадает с ожидаемым.");
    }

    @Test
    public void yandexLogoUrlTest() {
        MainPagePOM mainPagePOM = new MainPagePOM(driver);

        mainPagePOM.logoYandexClick();

        String scooterPageHandle = driver.getWindowHandle();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1); //вкладок  стало больше одной

        for (String handle: driver.getWindowHandles()) {
            if (!handle.equals(scooterPageHandle)) { //Ищем любую другую
                driver.switchTo().window(handle);
                break;
            }
        }
            String currentUrl = driver.getCurrentUrl();

            assertEquals("https://dzen.ru/?yredirect=true",currentUrl,  "Открылась другая страница"); //Большой вопрос: в задании сказано, что открываться должна страница яндекса, но там-то дзен теперь... Решил изменить на дзен, задание явно не на сравнение той или иной страницы, а на переключение между вкладками.
        }
    }



