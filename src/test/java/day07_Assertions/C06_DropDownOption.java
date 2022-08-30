package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

//amazona gidip dropdown dan books secenegını secıp sectıgımız option ı yazdıralım
//dropdown daki opsiyon sayısının 28 oldugunu test edelim

public class C06_DropDownOption {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver() .setup() ;
        driver= new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );
        driver .get("http://www.amazon.com") ;



    }
    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread .sleep(3000) ;
        driver .quit() ;
    }

    @Test
    public void test(){
        //WebElement dropdownmenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']")) ;
        //Select secim = new Select(dropdownmenu ) ;// yada asagıdaki gibi kısadan da yapabiliriz
        Select secim2 = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        secim2.selectByVisibleText("Books");

        //BİR DROPDOWN İLE CALISIYORKEN SON SECILEN OPTİONA ULASMAK İCİN .getFirstSelectedOption() METODU OLUSTURULUR
        //BU METHOD BİZE WEBELEMENT DONDURUR VE UZERINDEKİ YAZIYI YAZDIRMAK ICIN GET TEXT METHODU CALISTIRILIR

        System.out.println(secim2.getFirstSelectedOption().getText() );
        System.out.println(secim2.getOptions().size() );

       // getoptions() webelemntlerden olusan bir liste dondurur
        List<WebElement> options=secim2.getOptions() ;
        Assert.assertEquals(options.size(),28);  //yada asagıdaki gibi de yapılabılır

        Assert .assertEquals(secim2 .getOptions() .size() ,28) ;
    }
}
