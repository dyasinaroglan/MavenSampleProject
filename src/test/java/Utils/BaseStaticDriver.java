package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseStaticDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // driver ilk açılırken yüklenmesini bekletiyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // her element için bekleme süresi
        // TODO: 8.03.2022 2implicit wait---> Aranan herbir element için precence olmasını bekler
        // TODO: 8.03.2022 max 30 saniye bekleyecek. her 0.5 saniye de bir kontrol eder.bulduğu an geçer.

         wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // TODO: 8.03.2022 2.explicit --> elementin durumuna göre özel bekleme türü
        // TODO: 8.03.2022  bir elementin visible olana kadar yad clickable oluncaya kadar beklenemsi. elemente özel bekleme

         */

    }
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void clickTo(By locator){
        // 1.yazılışı ---> driver.findElement(locator).click();
        // 2. yazılışı ----> WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //element.click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        //By locator demek by sınıfından By.xpath
                                       //  By.ByCssSelector
                                        // By.id() bir locator.
    }
    public static void sendKeysTo(By locator, String str){
        //driver.findElement(locator).sendKeys(str);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
        //webElement return ettiği için click yapabiliyorum.
    }
    public static void takeScreenShotBySelenium(WebDriver driver) throws IOException {
        String fileName = "ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scrShot = (TakesScreenshot) BaseStaticDriver.driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("screenshot\\" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile,destFile);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void takeScreenShotByRobot(Rectangle rectangle) throws AWTException, IOException {
        Robot robot = new Robot();

        //bütün ekranı aldım. kaydedilecek ekran alanını belirliyoruz.
        BufferedImage image = robot.createScreenCapture(rectangle);
        //ekranda belirlenen dikdörtgeni resim olarak buffer'a atar.
        //robota ekran kaydını al ram' e kopyala diyoruz. üstte belirlediğimiz rect'i buffer'a at diyoruz.


        //sonra buna isim vermemiz lazım. dosya olarak kaydederken vereceğimiz isim
        //String filename = "screenshot\\" + fileName + ".png";
        //yada
        String filename = "ScreenShotRobot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); //bu şekilde de yazılabilir.
        //Yer belirtmezsek projenin altına kopyalar
        File destFile = new File("screenshot\\" + filename + ".png");
        ImageIO.write(image,"png", destFile);

    }

    public static void takeScreenShotByRobot(int x,int y, int widht, int height) throws AWTException, IOException {
        Robot robot = new Robot();

        Rectangle rectangle = new Rectangle(x,y,widht,height);

        //bütün ekranı aldım. kaydedilecek ekran alanını belirliyoruz.
        BufferedImage image = robot.createScreenCapture(rectangle);
        //ekranda belirlenen dikdörtgeni resim olarak buffer'a atar.
        //robota ekran kaydını al ram' e kopyala diyoruz. üstte belirlediğimiz rect'i buffer'a at diyoruz.


        //sonra buna isim vermemiz lazım. dosya olarak kaydederken vereceğimiz isim
        //String filename = "screenshot\\" + fileName + ".png";
        //yada
        String filename = "ScreenShotRobot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); //bu şekilde de yazılabilir.
        //Yer belirtmezsek projenin altına kopyalar
        File destFile = new File("screenshot\\" + filename + ".png");
        ImageIO.write(image,"png", destFile);

    }
    public static void takeScreenShotByRobot() throws AWTException, IOException {
        Robot robot = new Robot();

        Rectangle rectangle = new Rectangle();

        //bütün ekranı aldım. kaydedilecek ekran alanını belirliyoruz.
        BufferedImage image = robot.createScreenCapture(rectangle);
        //ekranda belirlenen dikdörtgeni resim olarak buffer'a atar.
        //robota ekran kaydını al ram' e kopyala diyoruz. üstte belirlediğimiz rect'i buffer'a at diyoruz.


        //sonra buna isim vermemiz lazım. dosya olarak kaydederken vereceğimiz isim
        //String filename = "screenshot\\" + fileName + ".png";
        //yada
        String filename = "ScreenShotRobot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); //bu şekilde de yazılabilir.
        //Yer belirtmezsek projenin altına kopyalar
        File destFile = new File("screenshot\\" + filename + ".png");
        ImageIO.write(image,"png", destFile);

    }

}
