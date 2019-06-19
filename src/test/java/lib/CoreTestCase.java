package lib;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {

    protected static WebDriver driver;

    @BeforeAll

    protected void setUp() throws Exception {
        super.setUp();  // method setUp from junit
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\old\\IdeaProjects\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //растягиваем браузер на весь экран
        driver.manage().window().maximize();

        //загрузка страницы
        driver.get("https://yandex.ru");
    }

    @AfterAll
    protected void tearDown() throws Exception {
        if (driver!=null)
        driver.quit();
        super.tearDown();  // method tearDown from junit
    }

}



