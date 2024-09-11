import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  extends PageBase{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    private By  EmailField = By.name("Email");
    private WebElement EmailFieldEle;
    private By  PasswordField = By.name("Password");
    private WebElement  PasswordFieldEle;
    private By RememberMeCheckBox = By.id("RememberMe");
    private WebElement RememberMeEle;
    private By LoginButton = By.xpath("//button[@class='button-1 login-button']");
    private WebElement LoginButtonEle;
    private By ForgetPassword = By.className("forgot-password");
    private WebElement ForgetPasswordEle;
    public void EnterEmail (String Email)
    {
        EmailFieldEle = driver.findElement(EmailField);
        SendText(EmailFieldEle,Email);
    }
    public void EnterPassword (String Password)
    {
        PasswordFieldEle = driver.findElement(PasswordField);
        SendText(PasswordFieldEle,Password);
    }

    public void ClickingOnRememberMeCheckBox()
    {
        RememberMeEle = driver.findElement(RememberMeCheckBox);
        Clicking(RememberMeEle);
    }

    public void ClickingOnLoginButton()
    {
        LoginButtonEle = driver.findElement(LoginButton);
        Clicking(LoginButtonEle);

    }
    public ForgetPasswordPage ClickOnForgetPassword()
    {
        ForgetPasswordEle = driver.findElement(ForgetPassword);
        Clicking(ForgetPasswordEle);
        return new ForgetPasswordPage(driver);
    }




}
