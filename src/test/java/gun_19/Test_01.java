package gun_19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class Test_01 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.findElement(By.id("")).getRect(); //başlangıç noktası ile gebişlik ve yüksekliği verir.
        driver.findElement(By.id("")).getLocation(); //başlabgıç noktası (x,y) verir.  POİNT
        driver.findElement(By.id("")).getSize();  //Genişlik ve yüksekliği verir. (height,width)  DİMENSİON
        // TODO: 13.03.2022    getRect() =      getLocation + getSize();   (POİNT+DİMENSİON)

        Rectangle rect = new Rectangle();
        rect.x = 100;
        rect.y = 100;
        rect.height = 300;
        rect.width = 500;


    }
}
