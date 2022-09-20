package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_IstenenWebElementScreenShot extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //amazona gidip nutella aratalım ve sonuc saysının oldugu web elementın fotografını cekelım

        driver .get("https://www.amazon.com");
        driver .findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER ) ;


        //webelement locate edilecek

        WebElement sonucyazisiElementi=driver .findElement(By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div")) ;

        File sonucyazielementSS=new File("target/ekranGoruntusu/sonucyazisiSs.jpeg") ;

        File temp=sonucyazisiElementi.getScreenshotAs(OutputType.FILE ) ;

        FileUtils .copyFile(temp ,sonucyazielementSS);
    }
}
