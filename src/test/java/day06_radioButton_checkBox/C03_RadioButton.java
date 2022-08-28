package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;
    // radio button u birini sectıgınde digerinin click inin kalkması

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver() .setup() ;
        driver=new ChromeDriver() ;
        driver.manage().window() .maximize() ;
        driver .manage() .timeouts() .implicitlyWait(Duration.ofSeconds(10) );


    }




    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000) ;

       driver.close() ;
    }
    @Test
public void test01(){
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com") ;

        //- “Create an Account” button’una basin
        driver .findElement(By.xpath("(//a[@role='button'])[2]")).click() ;
        //- “radio buttons” elementlerini locate edin
        WebElement femaleRadioButton=driver .findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleRadioButton=driver .findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement prvRadioButton=driver .findElement(By.xpath("(//input[@type='radio'])[3]"));
        //- Secili degilse cinsiyet butonundan size uygun olani secin

        if (!maleRadioButton.isSelected() ){
            maleRadioButton.click() ;
        }

    }


}
