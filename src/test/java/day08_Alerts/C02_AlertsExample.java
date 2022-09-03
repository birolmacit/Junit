package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AlertsExample {
    //● Bir class olusturun: Alerts
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver() .setup() ;
        driver= new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver .get("https://the-internet.herokuapp.com/javascript_alerts") ;

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread .sleep(5000) ;
        driver .close() ;

    }
    @Test
    public void acceptAlerts() {
        //● Bir metod olusturun: acceptAlert
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver .findElement(By.xpath("//*[text()='Click for JS Alert']")).click() ;
        driver .switchTo() .alert().accept() ;
        Assert .assertEquals(driver .findElement(By.xpath("//p[@id='result']")).getText() ,"You successfully clicked an alert");


    }

    @Test
    public void dismissAlerts() {
        //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver .findElement(By.xpath("//*[text()='Click for JS Confirm']")).click() ;
        driver .switchTo() .alert().dismiss() ;
        Assert .assertFalse(driver .findElement(By.xpath("//p[@id='result']")).getText() .contains("successfuly") ) ;


    }
    @Test
    public void sendKeysAlert() {
        //● Bir metod olusturun: sendKeysAlert
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver .findElement(By.xpath("//*[text()='Click for JS Prompt']")).click() ;
        driver .switchTo() .alert().sendKeys("birol") ;
        driver .switchTo() .alert() .accept() ;
        Assert .assertTrue(driver .findElement(By.xpath("//p[@id='result']")).getText() .contains("birol") ) ;


    }



}
