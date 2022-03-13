package gun_18;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Robot_02 {
    public static void main(String[] args) throws AWTException, IOException {
        Runtime.getRuntime().exec("notepad.exe"); //not defterine bunu yazdırdım.
        Robot robot = new Robot();
       /* robot.waitForIdle(); //bir önceki işlemi bekle
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_D);

        */

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_Y);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_N);



    }
}
