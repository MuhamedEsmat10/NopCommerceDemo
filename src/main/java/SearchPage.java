import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }
    protected By SearchBox = By.xpath("//input[@id='small-searchterms']");
    protected WebElement SearchBoxEle;
    protected By SearchButton = By.xpath("//button[@class='button-1 search-box-button']");
    protected WebElement SearchButtonEle;
    public void SearchForProduct(String Text)
    {
        SearchBoxEle = driver.findElement(SearchBox);
        SendText(SearchBoxEle,Text);
    }
    public void ClickOnSearchButton()
    {
        SearchButtonEle = driver.findElement(SearchButton);
        Clicking(SearchButtonEle);
    }
}
