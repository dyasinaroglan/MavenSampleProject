package gun_18;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Robot_03 {
    public static void main(String[] args) throws AWTException, IOException {
        Runtime.getRuntime().exec("notepad.exe"); //not defterine bunu yazdırdım.

        StringSelection str = new StringSelection("JAVA DUNYASI");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);  //CTRL+C gibi yapmış oluyorum.


        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);





    }
}
