package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        driver .get("https://www.amazon.com.tr"); //önce arama kutusuna click yapıp harf harf nutella yazdıralım ve aratalım
        Actions actions = new Actions(driver );
        WebElement AramaKutusu=driver .findElement(By.id("twotabsearchtextbox"));
        actions .click(AramaKutusu ).keyDown(Keys.SHIFT)
                .sendKeys("n").keyUp(Keys.SHIFT )
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a").
        sendKeys(Keys.ENTER ).perform() ;
    }

}
