package day11_faker_file;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.devtools.v85.domsnapshot.model.StringIndex;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        //C:\MyProjects-1\batch59Junit
        //bana icinde oldugum projenin dosya yolunu (path ) verir

        System.out.println(System.getProperty("user.home"));
        //C:\Users\Lenovo
        //yani benim bilgisayaraımın bana ozel kısmını verdi


        //C:\Users\Lenovo\Downloads
        //C:\Users\Lenovo\Desktop
        //C:\MyProjects-1\batch59Junit\src\test\java\day11_faker_file\C03_FileExist.java


        //masaüstündeki text dosyasının varlığını test edin
        //C:\Users\Lenovo\Desktop\a.txt
        String dosyayolu=System .getProperty("user.home")+"\\Desktop\\a.txt";
        System.out.println(dosyayolu);

        /*
         bilgisayardaki bir dosyanın varlıgını test etmek icin once dosyaya ulasmamız gerekmektedir.
         javada dosyaya erisim saglamak icin yoluna (path )ine ihtiyac vardır
         her bilgisayaraın kullanıcı adı farklı olacagından masaustu yolu da birbirinden farklı olacaktır
         testlerimizin tum bilgisayarlarda calısması ıcın dosya yolunu dinamik yapmalıyız

         bunun icin her bilgisayarın birbirinden farklı yolunu bulmak icin
          String dosyayolu=System .getProperty("user.home")+"\\Desktop\\a.txt"; seklinde yazmalıyız

          mac icin "/desktop/a" seklinde ters slash
         */

        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert .assertTrue(Files .exists(Paths.get(dosyayolu)) );
        //Assert .assertFalse(Files .exists(Paths.get(dosyayolu)) ) ;

    }
}
