import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPassTestPage extends TestBase {
    private HomePage homePage;
    private  LoginPage loginPage;
    private  ForgetPasswordPage forgetPasswordPage;
    String email = "mohamedessmat8@test.com";
    @Test
    public void ForgetPassword() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = homePage.ClickingOnLoginButton();
        forgetPasswordPage = loginPage.ClickOnForgetPassword();
        forgetPasswordPage.EnterEmail(email);
        forgetPasswordPage.ClickOnRecoverButton();
        String expectedResult = "Email with instructions has been sent to you.";
        WebElement alert = driver.findElement(By.className("content"));
        String actualResult = alert.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);
    }
    @Test(description = "using invalid Email")
    public void ForgetPass() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = homePage.ClickingOnLoginButton();
        forgetPasswordPage = loginPage.ClickOnForgetPassword();
        forgetPasswordPage.EnterEmail("mohamedesmat14@test.com");
        forgetPasswordPage.ClickOnRecoverButton();
        String expectedResult = "Email not found.";
        WebElement alert = driver.findElement(By.className("content"));
        String actualResult = alert.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);
    }
}
