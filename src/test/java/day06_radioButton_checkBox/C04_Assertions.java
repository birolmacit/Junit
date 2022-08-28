package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver() .setup() ;
        driver =new ChromeDriver() ;
        driver .manage() .window() .maximize() ;

        driver.manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );

    }

    @After public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver .close() ;
    }
    @Test public void test(){
        //EGER TEST METHODUMUZDA HICBIR TEST YOKSA TEST CALISTIKTAN SONRA HICBIR PROBLEMLE KARSILASILMADIGINI RAPORLAMAK ICIN TEST PASSED YAZISI CIKAR
        // eger testleri if ile yaparsak test basarısız olsa bile kodlar problemsiz calıstıgı ıcın console da test gecerli diyecektir
        driver .get("https://www.amazon.com");

        //url in https://www.facebook.com olup olmadıgını test edin

       /* if(driver .getCurrentUrl().equals("https://www.amazon.com")){
            System.out.println("url test passed");
        }
        else{
            System.out.println("url test failed");
        }*/

        String expectedurl="https://www.facebook.com";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals("url beklenenden farkli",expectedurl, actualurl);


        System.out.println("calimaya devam etti");

        /*
        Assert class ı ile yaptıgımız testlerde assertion failed olursa java kodların calısmasını durdurur ve assert class ı bizi hata konusunda bilgilendirir.

        org.junit.ComparisonFailure: url beklenenden farkli
Expected :https://www.facebook.com
Actual   :https://www.amazon.com/
<Click to see difference>

gibi bir hata bilgisi verdi

    boylece hatanın ne oldugunu arastırmamıza gerek kalmadan Junit bize raporlamıs olacak
         */


    }
}
