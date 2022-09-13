package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. TextDoc.txt dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver .findElement(By.xpath("//*[text()='TextDoc.txt']")).click() ;

String dosyayolu=System .getProperty("user.home")+"\\Downloads\\TextDoc.txt";
        System.out.println(dosyayolu);
        Thread .sleep(5000) ;

      Assert.assertTrue(Files.exists(Paths .get(dosyayolu) )) ;
       // System .getProperty("user.home")+"\\Downloads\\TextDoc.txt"
    }
}
