package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownMenu {
    //amazona gidip dropdown dan BOOKS secenegini secip java kelimesini aratalım ve arama sonuclarında java yazdıgını test edelim

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
    public void test(){//

        // DROPDOWN DAN BİR OPTİON SECMEK İCİN 3 ADIMIMIZ VAR

       //Adim1: Dropdown menuyu herhangi bir locator ile locate edin ve bir webelemente atayalım
     WebElement dropdownmenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']")) ;

     //Adım2: Yeni bir “Select” objesi olusturun ve daha once locate ettigimiz WebElement’i parametre olarak yeni objeye ekleyin

        Select secim=new Select(dropdownmenu);

        //Adim 3: Select class’indan kullanabileceginiz 3 yontemden biriyle dropdown menusundeki elemananlardan istediginizi secin

        // <option value="search-alias=stripbooks-intl-ship">Books</option>slot     İNCELE KISMINDA BU SEKILDE CIKAR

        secim .selectByVisibleText("Books");//
        //secim .selectByIndex(5);//buradaki ilk tıkladıgımız 0.indextir dolayısıyla listedekilerin indexleri 1 den baslar
        //secim.deselectByValue("search-alias=stripbooks-intl-ship");


        //arama kutusuna java yazdıralım   ki bu bolum normal locate ederek zaten aratılıyor
       WebElement searchbox= driver .findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       searchbox .sendKeys("java"+ Keys.ENTER ) ;


       //arama sonucunun java ıcerip icermediğini asserttrue ile bakalım
        WebElement sonuc=driver .findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucyazisi=sonuc.getText();
        Assert.assertTrue(sonucyazisi .contains("java") );





    }
}
