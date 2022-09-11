package day10_actions;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase  {
    //1- Yeni bir class olusturalim: MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edelim.
    //5- Tamam diyerek alert’i kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01(){
        Actions actions=new Actions(driver );

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver .get("https://the-internet.herokuapp.com/context_menu");
        String ilksayfahash=driver .getWindowHandle();

        //3- Cizili alan uzerinde sag click yapalim
        actions .contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']")) ).perform() ;

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
       Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu")) ;

        //test edelim.
        //5- Tamam diyerek alert’i kapatalim
        driver .switchTo() .alert() .accept() ;
        //6- Elemental Selenium linkine tiklayalim
        actions .click(driver .findElement(By.xpath("//*[text()='Elemental Selenium']")) ) .perform() ;
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim ki burada baska bir pencereye actı
        //bu acılan yere gitmek için windowhandle dicez

        Set<String > handlelar =driver .getWindowHandles();
        String ikincisayfahash="";

        for (String each: handlelar ) {
            if(!each.equals(ilksayfahash )){
               ikincisayfahash=each  ;
            }

        }
driver .switchTo() .window(ikincisayfahash );
      Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getTagName().equals("h1")); ;

    }
}
