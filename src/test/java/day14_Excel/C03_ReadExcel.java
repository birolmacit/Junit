package day14_Excel;

import com.sun.source.tree.AssertTree;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        //input olarak verilen satirno sutunno degerlerini parametre olarak alıp o cell deki datayı
        //string olarak donduren bir method olusturun

        int satirNo=6;
        int sutunNo=2;
        String dosyayolu="src/recources/ülkeler.xlsx";

        String sonuc=tabloElemanı(satirNo ,sutunNo ,dosyayolu );
        System.out.println(sonuc );

    }

    private String  tabloElemanı(int satirno, int sutunNo, String dosyayolu) throws IOException {
        FileInputStream fis=new FileInputStream(dosyayolu );
        Workbook workbook =WorkbookFactory.create(fis );
        String sonuc=workbook .getSheet("Sayfa1") .getRow((satirno-1)) .getCell((sutunNo-1) ).toString() ;
    return sonuc ;}
}
