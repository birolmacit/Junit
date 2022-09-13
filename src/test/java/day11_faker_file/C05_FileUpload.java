package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2. https://the-internet.herokuapp.com/upload adresine gidelim
    //3. chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim.


    @Test
    public void test01() {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver .get("https://the-internet.herokuapp.com/upload") ;
        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.

       /* bu işlemi selenium ile yapma imkanımız yok cunku web tabanlı bir uygulama değil
         bu durumda sendKeys() metodu kullanılabilir.
        eger chooseFile butonuna var olan bir dosyanın yolunu yollarsanız secme işlemi otomatik olarak yapılmış olacaktır */

        //önce choosefile butonunu locate edelim sonra click e basalaım

       WebElement dosyasec= driver .findElement(By.id("file-upload")) ;


        //yüklenecek dosya yolunu olusturalım
         String dosyayolu=System .getProperty("user.home")+"\\Desktop\\a.txt";


         //sendkeys ile dosya yolunu secme butonuna yollayalım
        dosyasec.sendKeys(dosyayolu );

        //5. Upload butonuna basalim.

        driver .findElement(By.id("file-submit")).click() ;

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver .findElement(By.xpath("//h3")).isDisplayed() ) ;

    }
}
