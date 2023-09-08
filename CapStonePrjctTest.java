
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CapStonePrjctTest {

    //Constants
    public static final String baseUrl = "https://www.saucedemo.com";
    public static final String driver_exe_path = "\\chromedriver.exe";

    //Varables
    WebDriver driver;

    @BeforeSuite
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver",driver_exe_path);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    @Parameters ({"username_valid", "pwd_valid"})
    public void testLoginSuccess() {
        LoginPage.loginMethod(driver, "username_valid", "pwd_valid");
        Screenshots.getScreenshot(driver, "\test-output");
        Assert.assertTrue(driver.findElements(LoginPage.product_catalog).size() > 0, "Login is Un-successful, pls check what is the issue");
        LoginPage.logoutMethod(driver);
    }

    @Test
    @Parameters ({"username_invalid", "pwd_invalid"})
    public void testLoginFailure() {
        LoginPage.loginMethod(driver, "username_invalid", "pwd_invalid");
        Screenshots.getScreenshot(driver, "\test-output");
        Assert.assertTrue(driver.findElements(LoginPage.login_error).size() > 0, "Login Error is not displayed, but it should not be. Pls check what is the issue");
    }

    @AfterSuite
    public void closeDriver(){
        driver.close();
    }

}
