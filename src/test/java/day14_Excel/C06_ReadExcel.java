package day14_Excel;

import com.sun.source.tree.AssertTree;
import net.bytebuddy.asm.Advice;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //excel dosyasındaki tüm verileri classımıza alıp bir java objesine store edelim
        //boylece her seferinde excel e ulasıp satır sutun ile ugrasmayalım

        //database yapısında olan exceli koyabilecegımız en uygun java objesi Map tir

        Map<String ,String > ulkelerMap=new HashMap<String ,String>();

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/recources/ülkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fiiiis= new FileInputStream(dosyayolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook calismakagidi= WorkbookFactory.create(fiiiis);

        int sonsatirIndexi=calismakagidi.getSheet("Sayfa1").getLastRowNum() ;

        for (int i = 0; i <=sonsatirIndexi  ; i++) {
            //key i.satırdaki 1. indextir
            String key=calismakagidi .getSheet("Sayfa1").getRow(i).getCell(1).toString() ;

            //value ise i.satirdaki 2 ve 3.indextekilerin birleşimi olacak
            String value=calismakagidi .getSheet("Sayfa1").getRow(i).getCell(2).toString()+" , "+
                    calismakagidi .getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap .put(key,value );
            
        }

        System.out.println(ulkelerMap );

        //listede gana oldugunu test edelim

        Assert.assertTrue(ulkelerMap .keySet() .contains("Gana") );



    }
}
