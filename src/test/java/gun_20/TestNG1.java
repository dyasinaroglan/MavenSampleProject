package gun_20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG1 {
    //burada çalıştırırsam TestNG1

    //junit, TestNG
    {
        System.out.println("aaaaa");
    }
    @Test
    public void test01(){
        //burada tıklayıp run edersem sadece test01 test edilir.
        Assert.assertEquals(1,1,"hata");


    }
    @Test
    void test02(){
        //burada tıklayıp run edeersem sadece test02 test edilir.
        int a = 4;
        int b = 3;

        int expected = 7;  //beklenen değer
        int actual = sum(a,b);  // gerçekleşen değer
        Assert.assertEquals(actual,expected,"Beklenen " + expected + ",actual " + actual);
    }
    public int sum(int a,int b){
        return a+b;
    }
}
