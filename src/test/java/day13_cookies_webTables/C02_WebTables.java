package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

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

        girisYap();

        //● table( ) metodu oluşturun
       tableMetodu();

        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

    }
    //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    private void tableMetodu() {
    }

    //● login( ) metodun oluşturun ve oturum açın.
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
