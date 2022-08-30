package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//1) Bir class oluşturun: BestBuyAssertions
//2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
//testleri yapin
//○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
//○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
//○ logoTest => BestBuy logosunun görüntülendigini test edin
//○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

public class C02_BestBuyAssertions {
    static WebDriver driver;

    //1) Bir class oluşturun: BestBuyAssertions
    @BeforeClass
    public static void setUp() {
        WebDriverManager .chromedriver() .setup() ;
        driver = new ChromeDriver();
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        //testleri yapin
        driver .get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread .sleep(5000) ;
        driver .close() ;
    }
    @Test
    public void test01() {

        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        Assert.assertEquals(driver .getCurrentUrl(),"https://www.bestbuy.com/");


    }
    @Test
    public void test02() {
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert .assertFalse(driver .getTitle().contains("Rest") ) ;



    }
    @Test
    public void test03() {
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }


    @Test
    public void test04() {
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());

    }

}
