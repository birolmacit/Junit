package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//1) Bir class oluşturun: YoutubeAssertions
//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
//○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

public class C03_YoutubeAssertions {
    //1) Bir class oluşturun: YoutubeAssertions
    static WebDriver driver ;


    @BeforeClass
    public static void setUp() {
        WebDriverManager .chromedriver() .setup() ;
        driver = new ChromeDriver() ;
        driver .manage().window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );
        //2) https://www.youtube.com adresine gidin
        driver .get("https://www.youtube.com") ;
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread .sleep(3000) ;

        driver .close() ;

    }
    @Test
    public void test01() {
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

        Assert .assertEquals(driver .getTitle(),"Youtube");
    }


    @Test
    public void test02() {

        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        Assert .assertTrue(driver .findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]")).isDisplayed() );
    }

    @Test
    public void test03() {

        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        Assert .assertTrue(driver .findElement(By.xpath("//input[@id='search']")).isEnabled() );
    }


    @Test
    public void test04() {

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        Assert .assertFalse(driver .getTitle().equals("youtube") ) ;
    }


}
