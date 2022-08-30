package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C07_DropDownExample {

    //● Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın




    static WebDriver driver;

   @BeforeClass
    public static void setUp(){
       WebDriverManager.chromedriver() .setup() ;
       driver =new ChromeDriver() ;
       driver .manage() .window() .maximize() ;
       driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );
       //● https://the-internet.herokuapp.com/dropdown adresine gidin.
       driver .get("https://the-internet.herokuapp.com/dropdown") ;


   }

   @AfterClass
    public static void tearDown() throws InterruptedException {
       Thread.sleep(5000) ;

      // driver .quit() ;

   }

   @Test
    public void test(){
       //1.    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
       Select secim = new Select(driver .findElement(By.xpath("//select[@id='dropdown']")) );
       secim .selectByIndex(1) ;
       System.out.println(secim.getFirstSelectedOption().getText() );

       //2.    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
       secim.selectByValue("2");
       System.out.println(secim.getFirstSelectedOption().getText() );

       //3.    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
       secim.selectByVisibleText("Option 1");
       System.out.println(secim.getFirstSelectedOption().getText() );

       //4. Tüm dropdown options ı yazdırın
       List<WebElement> liste=  secim.getOptions();
       System.out.println(liste);  //bu sekılde yazdırırsak referans adreslerini yazdırıyor yani webelementleri yazdırır
       //halbukı bizim webelement uzerınde yazan metinlere get text ile ulasmamız gerekıyor
       //bu yuzden for each ile yazdırıcaz

       for (WebElement each: liste ){
           System.out.println(each.getText());

       }


   }







}
