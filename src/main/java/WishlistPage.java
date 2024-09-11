import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends PageBase{

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    By RemoveItem = By.cssSelector("button[class=\"remove-btn\"]");
    WebElement RemoveItemEle;

    public void RemovingItemFromWishlist()
    {
        RemoveItemEle = driver.findElement(RemoveItem);
        Clicking(RemoveItemEle);
    }




}
