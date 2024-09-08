import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.DocFlavor;

public class RegisterPage extends PageBase {


    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }
      private By GenderMaleRadioButton = By.id("gender-male");
      private WebElement GenderEle;
      private By FirstNameField = By.id("FirstName");
      private WebElement FirstNameEle;
      private By LastNameField = By.name("LastName");
      private WebElement LastNameEle;
      private By EmailField = By.id("Email");
      private WebElement EmailEle;
      private By PasswordField = By.id("Password");
      private WebElement PasswordEle;
      private By ConfirmPassword = By.id("ConfirmPassword");
      private WebElement ConfirmPasswordEle;
      private By RegisterButton = By.name("register-button");
      private WebElement RegisterButtonEle;
      private By OkButton = By.xpath("//a[@class='button-1 register-continue-button']");
      private WebElement OkButtonEle;

    public void EnterFirstName(String FirstName)
    {
        FirstNameEle = driver.findElement(FirstNameField);
        SendText(FirstNameEle,FirstName);
    }
    public void EnterLastName(String LastName)
    {
        LastNameEle = driver.findElement(LastNameField);
        SendText(LastNameEle,LastName);

    }
    public void EnterEmail(String Email)
    {
        EmailEle = driver.findElement(EmailField);
        SendText(EmailEle,Email);
    }

    public void EnterPassword(String Password)
    {
        PasswordEle = driver.findElement(PasswordField);
        SendText(PasswordEle,Password);
    }
    public void ConfirmPassword(String Repassword)
    {
        ConfirmPasswordEle = driver.findElement(ConfirmPassword);
        SendText(ConfirmPasswordEle,Repassword);
    }
  public void ChooseGender()
  {
      GenderEle = driver.findElement(GenderMaleRadioButton);
      Clicking(GenderEle);
  }
  public void  ClickOnRegisterButton()
  {
      RegisterButtonEle = driver.findElement(RegisterButton);
      Clicking(RegisterButtonEle);

  }
public void ConfirmRegister()
{
    OkButtonEle = driver.findElement(OkButton);
    Clicking(OkButtonEle);
}














}
