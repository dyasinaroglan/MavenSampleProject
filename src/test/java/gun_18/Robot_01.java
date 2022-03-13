package gun_18;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Robot_01 {

    /*
    https://demo.guru99.com/test/upload/  bu sayfaya gidin
    minion.zip dosyasını indirin
     */

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        wait.until(ExpectedConditions.titleIs("File Upload Demo"));
        Thread.sleep(1000);
        driver.findElement(By.id("file_wraper0")).click();

        //robot class açıyorum. java.awt'ye aittir. upload, download daki pencereleri robot ile kontrol ederiz.
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        sleep(2000);

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);

        Driver.quitDriver();

    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


