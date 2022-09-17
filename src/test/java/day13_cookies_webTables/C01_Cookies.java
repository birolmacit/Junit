package day13_cookies_webTables;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    //Yeni bir class olusturun : cookiesAutomation
    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
    //olusturun ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin


    @Test
    public void test() {

        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver .get("https://www.amazon.com") ;
        //2- tum cookie’leri listeleyin
        Set<Cookie> cerezlerSet= driver .manage() .getCookies();
        System.out.println(cerezlerSet);

        for (Cookie each :cerezlerSet
             ) {
            System.out.println(each );

        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cerezlerSet .size() >5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each :cerezlerSet) {
            if(each.getName() .equals("i18n-prefs")){
                Assert.assertEquals("USD",each .getValue() );

            }
        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie cerez=new Cookie("en sevdiğim cookie","cikolatali");
        driver .manage() .addCookie(cerez );
        cerezlerSet= driver .manage() .getCookies();
        System.out.println(cerezlerSet);
        for (Cookie each :cerezlerSet
        ) {
            System.out.println(each );

        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert .assertTrue(cerezlerSet .contains(cerez )) ;
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver .manage() .deleteCookieNamed("skin");
        Assert .assertFalse(cerezlerSet.contains("skin") );
        //8- tum cookie’leri silin ve silindigini test edin
        driver .manage() .deleteAllCookies() ;

        cerezlerSet=driver .manage() .getCookies();
        Assert .assertTrue(cerezlerSet.isEmpty() );
    }
}
