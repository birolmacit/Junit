package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver() .setup() ;
        driver= new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );





    }
    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread .sleep(10000) ;
        //driver .quit() ;
    }

    @Test
    public void test01  (){
        //HERHANGİ BİR WEB SİTESİNE GİDİNCE VEYA BİR WEB SİTESİNDE HERHANGİ BİR İSLEM YAPTIGIMIZDA ORTAYA CIKAN UYARILARA ALERT DİYORUZ
        //EGER BİR ALERT İNSPECT yani inceleme YAPILABİLİYORSA O ALERT OTOMASYON İLE KULLANILABİLİR BU TUR ALERTLERE HTML ALERT DENİR VE BUNLAR ICIN EKSTRA BİR ŞSLEM YAPMAYA GEREK YOKTUR
        //TUM WEB ELEMENTLER GİBİ LOCATE EDEREK HANDLE EDERİZ

        //driver .get("http://www.facebook.com") ;// MESELA BURADAKİ ALERT HTML ALERT DİR.BI PENCERE CIKIIYO VE TIKLAYINCA PROBLEM HALLOLUYOR


        /*ANCAK WEB UYGULAMALARINDA HTML ALERTLERİN YANINDA JAVASCRIPT ALERT LER DE VARDIR VE BU JS ALERTLER LOCATE EDILEMEZ
        SELENIUM DA JS ALERTLER ICIN OZEL BIR YONTEM GELISTIRILMISTIR
         */

        driver .get("https://the-internet.herokuapp.com/javascript_alerts");
        driver .findElement(By.xpath("//*[text()='Click for JS Alert']")) .click() ;
        driver .switchTo() .alert().accept();

        //result kısmında "You successfully clicked an alert" yazzdıgını test edin
        Assert .assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText() ,"You successfully clicked an alert");

        /*driver .findElement(By.xpath("//*[text()='Click for JS Confirm']")) .click() ;
        driver .switchTo() .alert().dismiss();
        Assert .assertEquals(driver.findElement(By.xpath("//p[@id='You clicked: Cancel']")).getText() ,"You successfully clicked an alert");

       driver .findElement(By.xpath("//*[text()='Click for JS Prompt']")) .click() ;
        driver .switchTo() .alert().sendKeys("merhaba"+ Keys.ENTER );
        Assert .assertEquals(driver.findElement(By.xpath("//p[@id='You entered: merhaba']")).getText() ,"You successfully clicked an alert");*/



    }
}
