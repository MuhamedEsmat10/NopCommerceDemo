import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }
    By AddToWishlistBtn = By.id("add-to-wishlist-button-47");
    public WebElement AddToWishlistBtnEle;
    private By ProductQuantityInputField = By.name("addtocart_47.EnteredQuantity");
    private WebElement QuantityInputEle;
    public void ClickOnAddToWishlistButton()
    {
        AddToWishlistBtnEle = driver.findElement(AddToWishlistBtn);
        Clicking(AddToWishlistBtnEle);
    }
    public void InsertProductQuantity (String value)
    {
        QuantityInputEle = driver.findElement(ProductQuantityInputField);
        InsertQuantity(QuantityInputEle,value);
    }

}
