package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin




    //1- https://demoqa.com/droppable adresine gidelim
    @Test
    public void test01(){
        driver .get("https://demoqa.com/droppable") ;
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions= new Actions(driver);
           // WebElement tasinacak=driver .findElement(By.xpath("//div[@id='draggable']"));
           // WebElement hedef=driver .findElement(By.xpath("(//div[@id='droppable'])[1]"));
           // actions .dragAndDrop(tasinacak,hedef ).perform() ;

        //yada asagıdaki gıbı direkt olarak yapabiliriz

        actions .dragAndDrop(driver .findElement(By.xpath("//div[@id='draggable']")),driver .findElement(By.xpath("(//div[@id='droppable'])[1]"))).perform() ;

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertTrue(driver .findElement(By.xpath("//*[text()='Dropped!']")).getText() .equals("Dropped!") );
    }


}
