package gun_17;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        Test01 test01 = new Test01();
        test01.goToUrl("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        test01.fillForm("Admin","admin123");

        Test02 test02 = new Test02();
        test02.hoverMenu();
    }
}
