package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

//Get Screenshot / Tum Sayfa
//Selenium 3 ile tum sayfanin fotografini alabiliyorduk, Selenium 4 ile gelen guzel ozelliklerden bir tanesi de
//istedigimiz WebElement’in fotografini almamiza imkan tanimasi



//4.Adim : Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasına gidip tum sayfanın fotografını cekın
        driver .get("https://www.bestbuy.com") ;
        //1.Adim : Bir TakeScreenhot objesi olusturup driver’imizi TakeScreenhot’a cast yapalim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver ;

        //2.Adim : kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin path ile yeni bir File olusturalim
        File tumSayfaResim=new File("target/ekranGoruntusu/tumsayfa.jpeg");

        //3.Adim : Takescreenshot objesini kullanarak getScreenshotAs( ) methodunu calistiralim ve gelen resmi gecici bir file’a assign edelim
File geciciDosya=takesScreenshot .getScreenshotAs(OutputType.FILE );

        //4.Adim : Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya ,tumSayfaResim );
    }
}
