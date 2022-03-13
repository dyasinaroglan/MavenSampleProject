package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }


    public static WebDriver getDriver(Browsers browser) {
        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}


