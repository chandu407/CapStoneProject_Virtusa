
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Screenshots {

    public static void getScreenshot(WebDriver driver, String Filepath) {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(Filepath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        }
        catch(IOException ioe){
            System.out.println("File does not exist");
        }
    }
}
