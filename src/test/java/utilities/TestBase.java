package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.annotation.processing.SupportedSourceVersion;
import java.time.Duration;
import java.util.WeakHashMap;

public abstract class TestBase {
    //abstract yapmamızın sebebi bu class dan obje uretılmesının onune gecmektir

    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager .chromedriver() .setup() ;
        driver =new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(15000) ;
        driver .close();

    }
}
