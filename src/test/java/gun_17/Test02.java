package gun_17;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Test02 {
    WebDriver driver;

    public Test02(){
        driver = Driver.getDriver();
    }
    public void hoverMenu(){
        List<WebElement> menus = driver.findElements(By.cssSelector("ul#mainMenuFirstLevelUnorderedList>li"));
        for (WebElement element : menus) {
            new Actions(driver).moveToElement(element).pause(100).build().perform();
        }
    }
}
