package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    /*Ø 1.Adım: Actions class’ta bir object oluşturulur.
        Actions actions= new Actions(driver);



        Ø 2. Adım: Üzerinde çalışmak istediğiniz WebElement
        öğesini bulunur.
        WebElement element = driver.findElement(By.id("ID"));



        Ø 3.Adim : Ardından bu webelement üzerinde action
        gerçekleştirilir. Örneğin tıklamak için.
        actions.click(element).perform( );


        */


    @Test
    public void test01(){
        //amazon.com a gidip account menusunden create an account yapmak

        Actions aksiyons =  new Actions(driver );
        driver .get("https://www.amazon.com");

        WebElement signinelementi= driver .findElement(By.xpath("//*[text()='Account & Lists']"));
        aksiyons.moveToElement(signinelementi).perform() ;

       WebElement createlinki= driver .findElement(By.xpath("//span[@class='nav-text']"));
        aksiyons .click(createlinki).perform() ;    //yada asagıdaki gibi de yapılabilir

       // aksiyons .click(driver .findElement(By.xpath("//span[@class='nav-text']"))).perform() ;
    }
}
