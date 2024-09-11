import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
public class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void Setup()
    {
            driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com");


    }
    @AfterMethod
    public void TearDown()
    {
        driver.quit();
    }

}
