package day15_WriteExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void writeExcel() throws IOException {

        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyayolu="src/recources/ülkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis ) ;
        //4) 4.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook .getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");


        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook .getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(15000000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook .getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook .getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(250000);
        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyayolu );
       workbook .write(fos );
        //10)Dosyayi kapatalim
        fis.close() ;
        fos.close();

    }
}
