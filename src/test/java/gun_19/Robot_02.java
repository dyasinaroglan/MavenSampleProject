package gun_19;

import Utils.BaseStaticDriver;
import Utils.Driver;
import io.opentelemetry.api.internal.Utils;

import java.awt.*;
import java.io.IOException;

public class Robot_02 {
    public static void main(String[] args) throws IOException, AWTException {

        Driver.getDriver().get("https://www.google.com");
        BaseStaticDriver.takeScreenShotByRobot();
    }
}
