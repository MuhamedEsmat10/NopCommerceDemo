import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistPageTest extends PageBase{
    public WishlistPageTest(WebDriver driver) {
        super(driver);
    }
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    WishlistPage wishlistPage;
    String ItemName = "Apple iPhone 15 128GB";
    @Test(priority = 1)
    public void AddItemToWishlist()
    {
         searchPage = new SearchPage(driver);
         searchPage.SearchForProduct(ItemName);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         searchPage.ClickOnSearchButton();
         productDetailsPage = new ProductDetailsPage(driver);
         productDetailsPage.ClickOnAddToWishlistButton();
         String expectedResult = "The product has been added to your wishlist";
         WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='bar-notification success']"));
         String actualResult = SuccessMsg.getText();
         Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test(priority = 2)
    public void RemoveItemFromWishlist()
    {
        driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        wishlistPage = new WishlistPage(driver);
        wishlistPage.RemovingItemFromWishlist();
        String expectedResult = "The wishlist is empty!";
        WebElement RemovingMsg =driver.findElement(By.className("no-data"));
        String actualResult = RemovingMsg.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
