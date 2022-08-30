package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


//1. Bir Class olusturalim YanlisEmailTesti
//2. http://automationpractice.com/index.php sayfasina gidelim
//3. Sign in butonuna basalim
//4. Email kutusuna @isareti olmayan bir mail yazip enter’a
//bastigimizda “Invalid email address” uyarisi ciktigini test edelim

public class C04_YanlisEmailTesti {
    static WebDriver driver;
    //1. Bir Class olusturalim YanlisEmailTesti
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver() .setup() ;
        driver= new ChromeDriver() ;
        driver .manage() .window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(15) );
        //2. http://automationpractice.com/index.php sayfasina gidelim
        driver .get("http://automationpractice.com/index.php") ;



    }
    @AfterClass
    public static void tearDown() throws InterruptedException {

        Thread .sleep(3000) ;
    driver .close() ;
    }

    @Test
    public void test(){
        //3. Sign in butonuna basalim
        driver .findElement(By.xpath("//a[@class='login']")).click() ;


    }
    @Test
    public void test2(){

        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver .findElement(By.xpath("//input[@id='email_create']")).sendKeys("deneme.gmail.com"+ Keys .ENTER ) ;
        Assert.assertTrue(driver .findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());



}}
