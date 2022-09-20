package day14_Excel;

import com.github.dockerjava.api.model.SwarmOrchestration;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcel() throws IOException {

        //ülkeler sütununu yazdıralım


        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/recources/ülkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fiiiis= new FileInputStream(dosyayolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook calismakagidi= WorkbookFactory.create(fiiiis);
        int sonsatirNo=calismakagidi .getSheet("Sayfa1").getLastRowNum() ;
        System.out.println(sonsatirNo );  //bu index numarası verecegi icin son satırın gercek numarasından bşr eksıktır
        for (int i = 0; i <= sonsatirNo ; i++) {
            System.out.println(calismakagidi.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
    }
}
