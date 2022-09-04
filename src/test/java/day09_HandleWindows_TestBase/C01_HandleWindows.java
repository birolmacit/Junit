package day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {

    WebDriver driver;

    @Before
    public void setUp()  {
        WebDriverManager.chromedriver() .setup() ;
        driver = new ChromeDriver();
        driver.manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread .sleep(5000);
        driver .close() ;

    }
    @Test
public void test01(){
        // 1-amazon anasayfaya gidin
        //2-nutella aramasını yaptırın
        driver .get("https://www.amazon.com");
        String ilksayfaHandleDegeri=driver.getWindowHandle();
        driver .findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER ) ;

        /*
        CDwindow-FABD26FB791DB4790A8C476E73E8BC7E   ---->   bu kod acılan sayfanın unıque hash kodudur.selenıum sayfalar arası gecıste bu kodu kullanır


        eger sayfalar arasında drıverımızı gezdırıyorsak ve herhangı bır sayfadan su anda bulundugumuz sayfaya gecmek ıstıyorsak
        driver.switchTo().WİNDOW("CDwindow-FABD26FB791DB4790A8C476E73E8BC7E")    bu sayfanın handle degerini girerek bu sayfaya gecısı saglayabiliriz
         */


        //3- ilk urunun resmını tıklayarak farklı bır tab olarak acın
        WebElement ilkurunResmi=driver .findElement(By.xpath("(//img[@class='s-image'])[1]")) ;
     driver .switchTo() .newWindow(WindowType.TAB);

     // BU KOMUTU KULLANDIGIMIZDA DRİVER OTOMATİK OLARAK OLUSTURULAN NEW TABA GECER
        //YENİ TAB DA GOREVLERİ GERCEKLESTİRMEK İCİN ADIMLARI BASTAN YAPMAMIZ GEREKIR

        driver .get("https://www.amazon.com");
        driver .findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER ) ;
        driver .findElement(By.xpath("(//img[@class='s-image'])[2]")).click() ;

        //4 - yeni tabda acılan urunun baslıgını yazdırın
        System.out.println(driver.findElement(By.xpath("//span[@id='logo-ext']")).getText());



        //ilk sayafaya gecip url yi yazdıralım
        driver .switchTo() .window(ilksayfaHandleDegeri );
        System.out.println(driver.getCurrentUrl());
    }



}
