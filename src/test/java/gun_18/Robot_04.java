package gun_18;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Robot_04 {


    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demo.guru99.com/test/upload/");
        wait.until(ExpectedConditions.titleIs("File Upload Demo"));
        Thread.sleep(1000);
        driver.findElement(By.id("file_wraper0")).click();

        StringSelection str = new StringSelection("C:\\Users\\yasin\\Desktop\\Selendı.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

        sleep(1000);
        robot.waitForIdle();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.waitForIdle();
        sleep(2000);

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#res")));

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


