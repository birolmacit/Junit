package day12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExpilicitlyWait extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin
    @Test
    public void implicitWaitTesti() {
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver .get("https://the-internet.herokuapp.com/dynamic_controls") ;



        //4. Remove butonuna basin.
        driver .findElement(By.xpath("//*[text()='Remove']")).click() ;

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin
        // Assert .assertTrue(driver .findElement(By.xpath("//p[@id='message']")).isDisplayed())  ;
        Assert .assertTrue(driver .findElement(By.xpath("//p[text()=\"It's gone!\"]")).isDisplayed())  ;


        //6. Add buttonuna basin
        driver .findElement(By.xpath("//*[text()='Add']")).click() ;

        //7. It’s back mesajinin gorundugunu test edin
        Assert .assertTrue(driver .findElement(By.xpath("//p[text()=\"It's back!\"]")).isDisplayed())  ;

// eger testbase deki implicitywait kodunu kaldırırsak beklememız gereken ogelerı beklemez ve test failed olur
    }

    @Test
    public void explicitlyWaitTesti() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver .get("https://the-internet.herokuapp.com/dynamic_controls") ;
        //4. Remove butonuna basin.
        driver .findElement(By.xpath("//*[text()='Remove']")).click() ;
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*
        bekle.until(ExpectedConditions.visibilityOf(driver .findElement(By.xpath("//p[text()=\"It's back!\"]")))) ;

        Assert .assertTrue(driver .findElement(By.xpath("//p[text()=\"It's gone!\"]")).isDisplayed())  ;*/

        /*yazının gorunur olmasını beklerken yazının locate ını kullanmak sorun olusturur cunku henuız gorunmeyen bir yazının locate edılmesi mumkun olmayabılır
        (HTML kodları yazanlar farklı bir uygulama yaparlarsa durum degısebilir)

        bu durumda bekleme işlemini ve locate i birlikte yapmalıyız
         */

        WebElement itsgoneyazisi=bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]"))) ;
        Assert .assertTrue(itsgoneyazisi.isDisplayed());

        //6. Add buttonuna basin
        driver .findElement(By.xpath("//*[text()='Add']")).click() ;

        //7. It’s back mesajinin gorundugunu test edin
        bekle .until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]"))) ;
        Assert .assertTrue(driver .findElement(By.xpath("//p[text()=\"It's back!\"]")).isDisplayed())  ;
    }
}
