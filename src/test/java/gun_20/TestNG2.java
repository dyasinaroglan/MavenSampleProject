package gun_20;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG2 {
    WebDriver driver;
    @Test(priority = 1)  //priority si düşük olanı önce test eder. priority yazmazsak default değeri 0 dır.
    void test01(){
        driver = Driver.getDriver();
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }
    @Test(priority = 2)
    void test02(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        WebElement submit = driver.findElement(By.id("btnLogin"));
        Assert.assertTrue(submit.isDisplayed());
        Driver.quitDriver();
    }
}
