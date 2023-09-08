import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage{

    //Selectors
    public static By username_txt = By.id("user-name");
    public static By pwd_txt = By.id("password");
    public static By login_btn = By.id("login-button");
    public static By product_catalog = By.className("inventory_list");
    public static By login_error = By.xpath("//*[contains(text(),'Username and password do not match')][@data-test='error']");
    public static By hamburger_icon = By.id("react-burger-menu-btn");
    public static By logout_btn = By.id("logout_sidebar_link");

    //Variable
    private static WebDriverWait webDriverWait;

    public static void loginMethod(WebDriver driver, String Username, String Pwd){
        webDriverWait = new WebDriverWait(driver, 20);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(username_txt));
        driver.findElement(username_txt).sendKeys(Username);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pwd_txt));
        driver.findElement(pwd_txt).sendKeys(Pwd);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(login_btn));
        driver.findElement(login_btn).click();
    }

    public static void logoutMethod(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, 20);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(hamburger_icon));
        driver.findElement(hamburger_icon).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logout_btn));
        driver.findElement(logout_btn).click();

        Assert.assertTrue(driver.findElements(username_txt).size()>0, "Logout is not successful");
    }
}