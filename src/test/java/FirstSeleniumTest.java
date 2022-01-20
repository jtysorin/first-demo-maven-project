import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FirstSeleniumTest {
    static String browser;
    static WebDriver driver;
    public static void main(String[] args) {
        String browser = "";
        try {
            browser = PropertiesFile.readPropertiesFile();
            PropertiesFile.writePropertiesFile();
            browser = PropertiesFile.readPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBrowser(browser);
        setBrowserConfig();
        runTest();

    }

    /**
     * Setting the browser that you want to run
     * @author Sorin Jitianu
     * @param theBroswer the browser name of the browser you want to run the app
     */
    public static void setBrowser(String theBroswer){
        browser = theBroswer;
    }

    public static void setBrowserConfig(){
        if(browser.toLowerCase().contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browser.toLowerCase().contains("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if(browser.toLowerCase().contains("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    public static void runTest(){
        driver.get("https://selenium.dev/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
