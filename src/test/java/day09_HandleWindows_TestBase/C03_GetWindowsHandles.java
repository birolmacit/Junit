package day09_HandleWindows_TestBase;

import com.sun.jdi.event.MonitorContendedEnteredEvent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_GetWindowsHandles {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    //doğrulayın.

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
        //driver .close() ; //sadece en son pencereyi kapatır
        driver.quit() ;

    }
    @Test
    public void test01(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver .get("https://the-internet.herokuapp.com/windows") ;

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertFalse(driver .findElement(By.xpath("//h3")).getText().equals("Open a new window")) ;



        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver .getTitle().equals("The Internet")) ;


        /*eger kontrolsuz acılan bir tab veya window varsa o zaman o sayfaların window handle degerlerini elde etmem gerekir
        oncelikle ıkıncı sayfa acılmadan once ılk sayfanın window handle degerini bir string e atayalım

         */

        String ilksayfahandledegeri=driver .getWindowHandle();
        System.out.println(ilksayfahandledegeri);


        //● Click Here butonuna basın.
        driver .findElement(By.linkText("Click Here")) .click() ;
        /*buraya tıkladıgımızda yeni bir tab penceresine gidiyor
         ama driver hala eski pencerede kalmıs oluyor.switchTo.newWindow dmeeden link tıklayarak yeni tab veya window olusturuldugunda biz
        drivera yeni sayfaya gec demedikce driver eski sayfada kalır ve yeni sayfa ile ilgili hicbir işlem yapmaz yeni sayfada driver i calıstırmak isterseniz
        once driveri yeni sayfaya yollamalısınız*/



   /*
   yeni sayafaya gecebilmek icin oncelikle ikinci sayfanın handle degerini bulmamız gerekir.bunu icin driver.getWindowHandles() methodu kullanarak acık olan
   tüm sayafaların handle degerlerini alıp bir set e assign ederiz

   ilk sayafanın window handle degerini zaten biliyoruz setteki window handle dedgeerlerini kontrol edip
   ilk sayfanın handle degerine esit olmayan ıkınci sayfanın handle degeridir

    */
        Set<String> windowhandleseti=driver .getWindowHandles();
        System.out.println(windowhandleseti );
        String ikincisayfahandledegeri="";

        for (String each : windowhandleseti) {
            if (!each.equals(ilksayfahandledegeri)) {

             ikincisayfahandledegeri=each; }
            }


// afrtık ıkıncı sayfanın window handle degerini biliyoruz

        driver.switchTo() .window(ikincisayfahandledegeri) ;



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver .getTitle().equals("New Window") ) ;
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver .findElement(By.xpath("//h3")).getText() .equals("New Window") ) ;
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.

    }}
