import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends TestBase {
     private HomePage homePage;
     private  LoginPage loginPage;
     String email = "mohamedessmat8@test.com";
     String pass = "test$12345";
     @Test()
    public void ValidLogin() {
         homePage = new HomePage(driver);
         loginPage = homePage.ClickingOnLoginButton();
         loginPage.EnterEmail(email);
         loginPage.EnterPassword(pass);
         loginPage.ClickingOnRememberMeCheckBox();
         loginPage.ClickingOnLoginButton();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          String ExpectedResult = "https://demo.nopcommerce.com";
          String ActualResult = driver.getCurrentUrl();
          Assert.assertTrue(ActualResult.contains(ExpectedResult));

     }

     @Test(description = "login with wrong pass")
    public void InvalidLogin()
     {
         homePage = new HomePage(driver);
         loginPage = homePage.ClickingOnLoginButton();
         loginPage.EnterEmail(email);
         loginPage.EnterPassword("12345678");
         loginPage.ClickingOnLoginButton();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
         String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                 "The credentials provided are incorrect";
          WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
           String actualResult =  ErrorMsg.getText();
           Assert.assertTrue(actualResult.contains(expectedResult));
     }






}
