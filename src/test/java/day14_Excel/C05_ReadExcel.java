package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/recources/ülkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fiiiis= new FileInputStream(dosyayolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook calismakagidi= WorkbookFactory.create(fiiiis);


        //sayfa 2 ye gidip satır sayısının 24, kullanılan satır sayısının ise 12 oldugunu test edin

        int sonsatirIndex= calismakagidi.getSheet("Sayfa2").getLastRowNum() ;
        Assert .assertEquals(sonsatirIndex +1,24) ;

        int kullanilansatirsayisi=calismakagidi .getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilansatirsayisi );
    }
}
