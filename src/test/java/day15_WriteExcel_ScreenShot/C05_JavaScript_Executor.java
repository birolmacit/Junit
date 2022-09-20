package day15_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_JavaScript_Executor extends TestBase  {
    @Test
    public void JsExecutor() {

        //amazona gidelim

        driver .get("https://www.amazon.com/");

        //asagidaki sign in butonu görünceye kadar js ile scrool yapalım

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        WebElement signinbutonu=driver .findElement(By.xpath("//*[@id=\"icp-touch-link-country\"]/span[2]"));
        jse .executeScript("arguments[0].scrollIntoView(true);",signinbutonu );

        //sign in butonuna js ile click yapalım
        jse .executeScript("arguments[0].click();",signinbutonu );
    }
}
