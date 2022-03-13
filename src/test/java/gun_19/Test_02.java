package gun_19;

import Utils.BaseStaticDriver;
import Utils.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.Utils;

import java.awt.*;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test_02 {
    public static void main(String[] args) throws IOException, AWTException {
        /*
        https://www.snapdeal.com/ gidin
        search input "casio watch man" aratın
        ilk satır ürünlein ismini ekrana yazdırın
        ilk satır ürünlerinden random bir tanesine tıkla
        selenium ile ekran kaydı al
        robot ile sayfanın (100,100,500,500) alanın görüntüsünü kaydet.
         */
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com/");

        By search = By.xpath("(//input[@name='keyword'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys("casio watch man" + Keys.ENTER);

        By titleOfFirsRow = By.xpath("(//section)[2]//p[contains(@class,'title')]");//ilk satırdaki ürünlerin isimlerini ekrana yazdır
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(titleOfFirsRow,3));
        //selectorun elementleri 3 den fazla oluncaya kadar bekle demek
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(titleOfFirsRow));        //buradaki elementler gözükünceye kadar
        //isimleri ekrana yazdır
        list.forEach(webElement -> System.out.println(webElement.getText()));
        //mevcut sayfanın handle'ını ekrana yazdır
        String currentWindow = driver.getWindowHandle();


        /*
        Random r = new Random();
        r.nextInt(10,100);  10 ile 100 arasında random sayı ürettik

         */
        //ilk satır ürünlerden random bir tanesini tıkla
        list.get(new Random().nextInt(list.size())).click();
        //tüm sayfaların handlerini aldık
        Set<String> listOfWindows = driver.getWindowHandles();
        listOfWindows.remove(currentWindow);  //currentWindow u silersem diğer window. ana sayfanın handle'ını sildik

        new ArrayList<>(listOfWindows).get(0); //set i arrayList'e attım.
        driver.switchTo().window(new ArrayList<>(listOfWindows).get(0));

        String fileName = "ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot\\" + fileName + ".png");
        try {
            FileUtils.copyFile(scrFile,destFile);
        }catch (IOException e){
            e.printStackTrace();
        }

        BaseStaticDriver.takeScreenShotByRobot(new Rectangle(100,100,500,500));  //bütün ekranın görüntüsünü alıyor.
        //ya da
        //BaseStaticDriver.takeScreenShotByRobot(100,100,500,500); şeklinde de yapabilirim.
        WebElement resim = driver.findElement(By.xpath("(//li/img)[1]")); //saat üzerinde mouse hareketi, orta yıkarıdan aşağıya
        Actions actions = new Actions(driver);
        int widht = resim.getSize().getWidth(); //elementin genişliği
        int height = resim.getSize().getHeight(); //elementin yüksekliğini alır
        for (int i = -height/2; i < height/2-10; i+=10) {
            actions.moveToElement(resim,0, i).pause(10).build().perform();

        }
        actions.moveToElement(resim,0,0).build().perform();
        driver.close();
        Driver.quitDriver();

    }
}
