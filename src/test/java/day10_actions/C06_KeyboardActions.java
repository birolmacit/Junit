package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C06_KeyboardActions extends TestBase  {
    //facebook anasayfaya gidelim
    //yeni kayıt olustur butonuna basalım
    //isim kutusunu locate edip geriye kalan alanları tab ile dolasarak formu doldurun
    @Test
            public void test01(){
        Actions actions = new Actions(driver);
        driver .get("https://www.facebook.com");
driver .findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click() ;
        actions .click(driver .findElement(By.xpath("(//input[@type='text'])[2]")) ) .sendKeys("birol").sendKeys(Keys.TAB )
                .sendKeys("macit") .sendKeys(Keys.TAB ) .sendKeys("12345").sendKeys(Keys.TAB).sendKeys("12345bm").
                perform();


    }




}
