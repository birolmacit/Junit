package day13_cookies_webTables;

import jdk.jshell.execution.JdiExecutionControl;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C02_WebTables extends TestBase {
    //● Bir class oluşturun : C02_WebTables
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //○ Username : manager
    //○ Password : Manager1!
    //● table( ) metodu oluşturun
    //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows( ) metodu oluşturun //tr
    //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //○ 4.satirdaki(row) elementleri konsolda yazdırın.


    @Test
    public void webTable() {


        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //● login( ) metodun oluşturun ve oturum açın.
        girisYap();

        //● table( ) metodu oluşturun
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        WebDriverWait bekle=new WebDriverWait(driver , Duration.ofSeconds(10));
        bekle.until(ExpectedConditions .visibilityOfElementLocated(By.xpath("//table//tr[5]")) ) ;
        List<WebElement> satirlar=driver .findElements(By.xpath("//table//tr"));
        for (WebElement each : satirlar) {
            System.out.println(each.getText());
        }
        //yukarıdaki table altında tum row ları yazdırdı spesifik olarak tek bir hucreyi yazdırmak icn ise asagıdaki gibi yapıcaz
        System.out.println("");
        System.out.println("");
        List<WebElement > basliklar=driver .findElements(By.xpath("//table//thead//tr[1]"));
        for (WebElement each : basliklar ) {
            System.out.println(each.getText());
        }
        System.out.println(driver.findElement(By.xpath("//tbody//tr[6]//td[2]")).getText());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement> dorduncusatir= driver.findElements(By.xpath("//*[@id=\"datatable_ajax\"]/tbody/tr[3]"));
        for (WebElement each : dorduncusatir ) {
            System.out.println(each.getText());
        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
List<WebElement > dorduncusutun=driver .findElements(By.xpath("//table//tr//td[4]"));
        for (WebElement each : dorduncusutun ) {
            System.out.println(each.getText());
        }

        //email yazısının kacıncı index oldugunu bulun

        List<WebElement > basliklarlistesi=driver .findElements(By.xpath("//thead//tr[1]//th")) ;
        int emailsutunno=0;
        for (int i = 0; i < basliklarlistesi .size() ; i++) {
           if(basliklarlistesi .get(i).getText() .equals("Email") ) {
               emailsutunno =i+1;
           }

        }

        List<WebElement > emailsutunlistesi=driver .findElements(By.xpath("//tbody//td["+emailsutunno+"]"));

        for (WebElement each : emailsutunlistesi
             ) {
            System.out.println(each.getText());

        }

    }



    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        Actions actions= new Actions(driver );
        driver .findElement(By.xpath("//*[text()='Log in']")).click() ;
        //○ Username : manager
        //○ Password : Manager1!
        driver .findElement(By.xpath("//input[@class='form-control required']")).sendKeys("manager");
        actions .sendKeys(Keys.TAB ) .sendKeys("Manager1!").perform() ;
        driver .findElement(By.id("btnSubmit")).click() ;

    }
}
