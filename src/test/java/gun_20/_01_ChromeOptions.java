package gun_20;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;
import java.util.Set;

public class _01_ChromeOptions {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //test03_maximizeWithChromeOptions(); //açılır açılmaz maximize olarak açtı. chrome'un kendisi yaptı.
        test04_headless();


        Thread.sleep(2000);
        driver.quit();

    }

    public static void test01_normalOpen() {

        driver.get("https://www.google.com");

    }

    public static void test02_maximizeWithSelenium() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

    }

    public static void test03_maximizeWithChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        }
        public static void test04_headless(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());


        }
    }

