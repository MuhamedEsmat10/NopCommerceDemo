import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage extends LoginPage {

    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }

    private By EnterEmailField = By.id("Email");
    private WebElement EmailEle;
    private By RecoverButton = By.name("send-email");
    private WebElement RecoverButtonEle;

    public void  EnterEmailAddress(String Email)
    {
        EmailEle = driver.findElement(EnterEmailField);
        SendText(EmailEle,Email);
    }
    public void ClickOnRecoverButton()
    {
        RecoverButtonEle = driver.findElement(RecoverButton);
        Clicking(RecoverButtonEle);
    }


}
