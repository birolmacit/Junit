package day12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExpilicitlyWait extends TestBase {
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void is_enable_testi() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver .get("https://the-internet.herokuapp.com/dynamic_controls") ;
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
        driver .findElement(By.xpath("//*[text()='Enable']")).click() ;
        wait .until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")) );
        Assert .assertTrue(driver .findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed() ) ;
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    }
}
