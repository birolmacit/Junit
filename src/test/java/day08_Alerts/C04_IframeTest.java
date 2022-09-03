package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IframeTest {

    //● Bir class olusturun: IframeTest

    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○ Text Box’a “Merhaba Dunya!” yazin.
    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver() .setup() ;
        driver= new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver .get("https://the-internet.herokuapp.com/iframe");





    }
    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread .sleep(5000) ;
        driver .quit() ;
    }

    @Test
    public void iframeTest() {
        //● Bir metod olusturun: iframeTest
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        Assert.assertTrue(driver .findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).isDisplayed());//asagıdaki gibi bişr xpath de olabilirmis
        Assert.assertTrue(driver .findElement(By.xpath("//h3")).isEnabled());//sadece bir tane h3 tag nameli eleman oldugu icin

        System.out.println(driver.findElement(By.xpath("//h3")).getText());

//○ Text Box’a “Merhaba Dunya!” yazin.


        //textboox ı dogru locate etmemize ragmen driver  textbox ı bulamadı.burada html kodları ıncelenınce
        // texbox ın aslında bir i frame ıcerısınde oldugunu gorduk.bu durumda once ı frame i locate edip switchTo() komutuyla
        //o ,frame e gecmeliyız
        WebElement iframewebelementi = driver .findElement(By.id("mce_0_ifr"));
        driver .switchTo() .frame(iframewebelementi);

        driver .findElement(By.xpath("//body[@class='mce-content-body ']")).clear();
        driver .findElement(By.xpath("//body[@class='mce-content-body ']")).sendKeys("merhaba birol") ;


        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.

        driver .switchTo() .defaultContent() ;

        System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
       Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed() ) ;

//link yazı elementini dogru locate etmemize ragmen yazdırmadı cunku yukarıda ıframe e gecıs yapmıstık once buradan cıkmamız lazım
        //bu cıkısı da yukarıdaki  driver .switchTo() .defaultContent() ;   komutuyla yaptık



    }
}
