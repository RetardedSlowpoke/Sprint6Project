import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    @BeforeEach
    public void browserStartAndOpenPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--guest", "--disable-dev-shm-usage");
        //options.addArguments ("--headless"); //Хедлес вынесен отдельно для отладки - закомментил - посмотрел что происходит - раскомментил.

        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void browserQuit() {

        driver.quit();

    }
}