import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage extends PageBase {


    public HomePage(WebDriver driver)
    {
        super(driver);
    }
     By RegisterButton = By.className("ico-register");
     WebElement RegisterButtonEle;
     By LoginButton = By.className("ico-login");
     WebElement LoginButtonEle;
     By LogoutButton = By.className("ico-logout");
     WebElement LogoutButtonEle;
    public RegisterPage ClickingOnRegisterButton()
    {
        RegisterButtonEle = driver.findElement(RegisterButton);
        Clicking(RegisterButtonEle);
        return new RegisterPage(driver);
    }
    public LoginPage ClickingOnLoginButton()
    {
        LoginButtonEle = driver.findElement(LoginButton);
        Clicking(LoginButtonEle);
        return new LoginPage(driver);
    }
    public HomePage ClickingOnLogoutButton()
    {
        LogoutButtonEle = driver.findElement(LogoutButton);
        Clicking(LogoutButtonEle);
        return new HomePage(driver);
    }
}
