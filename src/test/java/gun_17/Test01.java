package gun_17;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Test01 {
        WebDriver driver;
        By lUsername = By.id("txtUsername");

        public Test01() {
            driver = Driver.getDriver();
        }

        public void goToUrl(String url){
            driver.get(url);

        }
        public void fillForm(String userName, String password){
            driver.findElement(By.id("txtUsername")).sendKeys(userName);
            driver.findElement(By.id("txtPassword")).sendKeys(password);
            driver.findElement(By.id("btnLogin")).click();
        }
    }

