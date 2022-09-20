package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelmetodu2() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/recources/ülkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fiiiis= new FileInputStream(dosyayolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook calismakagidi= WorkbookFactory.create(fiiiis);
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        System.out.println(calismakagidi.getSheet("Sayfa1").getRow(6).getCell(1).toString());
        //12. Row objesi olusturun sheet.getRow(index)
        //13. Cell objesi olusturun row.getCell(index)
    }
}
