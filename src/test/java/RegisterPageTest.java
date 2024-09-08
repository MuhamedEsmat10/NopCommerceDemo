import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterPageTest extends TestBase {
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();
    @Test(priority = 1)
    public void ValidRegister() {
        homePage = new HomePage(driver);
        registerPage = homePage.ClickingOnRegisterButton();
        registerPage.ChooseGender();
        registerPage.EnterFirstName("Mohamed");
        registerPage.EnterLastName("Essmat");
        registerPage.EnterEmail("mohamedessmat8@test.com");
        registerPage.EnterPassword("test$12345");
        registerPage.ConfirmPassword("test$12345");
        registerPage.ClickOnRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String ExpectedResult = "Your registration completed";
        String ActualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
        softAssert.assertTrue(ActualResult.contains(ExpectedResult));
        registerPage.ConfirmRegister();
        String expectedResultUrl = "https://demo.nopcommerce.com";
        String actualResultUrl =  driver.getCurrentUrl();
        Assert.assertTrue(actualResultUrl.contains(expectedResultUrl));

    }
    @Test(dependsOnMethods = "ValidRegister")
    public void RegisteredUserCanLogout()
    {
        homePage = new HomePage(driver);
        homePage.ClickingOnLogoutButton();
    }

    @Test(description = "confirm pass do not match with pass")
    public void InvalidRegister()
    {
        homePage = new HomePage(driver);
        registerPage = homePage.ClickingOnRegisterButton();
        registerPage.ChooseGender();
        registerPage.EnterFirstName("Mohamed");
        registerPage.EnterLastName("Essmat");
        registerPage.EnterEmail("mohamedessmat8@test.com");
        registerPage.EnterPassword("test$12345");
        registerPage.ConfirmPassword("1234578");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        registerPage.ClickOnRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String ExpectedResult = "The password and confirmation password do not match.";
        String ActualResult = driver.findElement(By.id("ConfirmPassword-error")).getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }

    @Test(description = "invalid Email format")
    public void InvalidRegister2()
    {
        homePage = new HomePage(driver);
        registerPage = homePage.ClickingOnRegisterButton();
        registerPage.ChooseGender();
        registerPage.EnterFirstName("Mohamed");
        registerPage.EnterLastName("Essmat");
        registerPage.EnterEmail("mohamedessmat8@test,com");
        registerPage.EnterPassword("test$12345");
        registerPage.ConfirmPassword("test$12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        registerPage.ClickOnRegisterButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String ExpectedResult = "Please enter a valid email address.";
        String ActualResult = driver.findElement(By.id("Email-error")).getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }


}
