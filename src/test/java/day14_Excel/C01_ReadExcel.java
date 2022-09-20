package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelMetodu() throws IOException {

        //1. apache poi dependency’i pom file’a ekleyelim
        //2. Java klasoru altinda resources klasoru olusturalim
        //3. Excel dosyamizi resources klasorune ekleyelim
        //4. excelAutomation isminde bir package olusturalim
        //5. ReadExcel isminde bir class olusturalim
        //6. readExcel() method olusturalim


        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/recources/ülkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyayolu);  //file input stream yolunu yazdıgımız exceli gidip okuyor koda ceviriyor
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis );   //okunan dosyayı workbook a kaydettık
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1"); //workbook tan gereklı sayfaya gittik
        //12. Row objesi olusturun sheet.getRow(index)   ///gerekli satır ve sutuna gidiyoruz
        Row row=sheet .getRow(6) ;
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row .getCell(1);

        System.out.println(cell.toString() );

        Assert .assertEquals(cell.toString() ,"Angola");
        Assert .assertEquals(cell.getStringCellValue(),"Angola");
    }
}
