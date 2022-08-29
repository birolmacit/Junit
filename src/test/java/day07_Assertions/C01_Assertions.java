package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
   static  WebDriver  driver;
    /* amazon anasayfaya gidin
    3 farklı test metodu olusturarak asagıdaki gorevleri yapın

    1-url nin amazon icerdiğini test edin
    2- title ın facebook ıcermedıgını test edin
    3-sol ust kosede amazon logosunun gorundugunu test edelım


     */

    @BeforeClass
    public static  void setUp()  {
        WebDriverManager.chromedriver() .setup() ;
        driver = new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000) ;
        driver.close() ;

    }


    @Test
    public void test01(){

        Assert.assertTrue("url testi basarısız", driver .getCurrentUrl().contains("amazon"));
    }
    @Test
    public void test02(){

        Assert.assertFalse("facebook testi basarısız", driver .getCurrentUrl().contains("facebook")) ;
    }
    @Test
    public void test03(){

       Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
    }



}
