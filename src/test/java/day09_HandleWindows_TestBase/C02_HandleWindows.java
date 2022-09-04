package day09_HandleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
        //1-amazona anasayfaya gidelım
        //2-url nin amazon icerdıgını test edelım
        //3-yeni bir pencere acıp bestbuy a gidelim
        //4-title in bestbuy icerdiğini test edelim
        //5-ilk sayfaya donup sayfada java aratalım
        //6-arama sonuclarının java icerdıgını test edelim
        //7-yeniden bestbuy ın acık oldugu sayfaya gidelim
        //8- logonun goruldugunu test edelim




        //1-amazona anasayfaya gidelım
        driver.get("https://www.amazon.com");
        String amazonhashcodu=driver.getWindowHandle();


        //2-url nin amazon icerdıgını test edelım
        Assert .assertTrue(driver .getCurrentUrl() .contains("amazon") );

        //3-yeni bir pencere acıp bestbuy a gidelim
        driver .switchTo() .newWindow(WindowType.WINDOW) ;
        driver .get("https://www.bestbuy.com") ;
        String bestbuyhashcodu=driver .getWindowHandle();
        //4-title in bestbuy icerdiğini test edelim
        Assert .assertFalse(driver .getTitle().contains("bestbuy") ) ;

        //5-ilk sayfaya donup sayfada java aratalım
        driver.switchTo() .window(amazonhashcodu ) ;
        driver .findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER ) ;

        //6-arama sonuclarının java icerdıgını test edelim
        Assert .assertTrue(driver .findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText() .contains("java") );
        //7-yeniden bestbuy ın acık oldugu sayfaya gidelim
        driver .switchTo().window(bestbuyhashcodu ) ;

        //8- logonun goruldugunu test edelim
        Assert .assertTrue(driver .findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed() ) ;


    }
}
