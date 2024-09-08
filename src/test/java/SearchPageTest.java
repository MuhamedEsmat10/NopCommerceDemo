import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest extends TestBase{
    String ItemName = "Apple iPhone 15 128GB";
    SearchPage searchPage;
    @Test()
    public void SearchForItem()
    {
        searchPage = new SearchPage(driver);
        searchPage.SearchForProduct(ItemName);
        searchPage.ClickOnSearchButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String expectedUrl = "https://demo.nopcommerce.com/apple-iphone-15-128gb";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
