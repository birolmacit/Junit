package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

    /*beforeclass ve afterclass methodları sadece static methodlar ıcın calısır o yuzden methodları static e cevirmelisin
    *
    * before ve after da her test oncesi ve sonrası ıslemler olusturulurken yani her test ıcın ayrı ayrı driverlar olusturulurken
    * beforeclass  ve afterclass da ise tek bir driver ile islem yapılır ve sonrfasında kapatılır
    * */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup() ;;
        driver = new ChromeDriver() ;
        driver.manage().window().maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    //her testin basında before method call vardır
    public void test01(){
        driver.get("https://www.amazon.com");
        //her testin somnunda after method call vardır
    }

    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
    }


    @Test
    public void test03(){
        driver.get("https://www.techproeducation.com");
    }
}


