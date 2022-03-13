package gun_19;

import Utils.Driver;
import org.openqa.selenium.By;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Robot_01 {
    public static void main(String[] args) throws AWTException, IOException {

        Robot robot = new Robot();

        Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        //bütün ekranı aldım. kaydedilecek ekran alanını belirliyoruz.

        BufferedImage image = robot.createScreenCapture(rect);
        //ekranda belirlenen dikdörtgeni resim olarak buffer'a atar.
        //robota ekran kaydını al ram' e kopyala diyoruz. üstte belirlediğimiz rect'i buffer'a at diyoruz.


        //sonra buna isim vermemiz lazım. dosya olarak kaydederken vereceğimiz isim
        String fileName = "screenshot\\ekranResmi.png";
        //Yer belirtmezsek projenin altına kopyalar
        ImageIO.write(image,"png", new File(fileName));



         }
}
