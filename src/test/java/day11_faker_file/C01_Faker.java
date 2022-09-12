package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker  extends TestBase {
    @Test
    public void test() {
        //facebook görevini fake isimlerle yapalım

        Actions actions = new Actions(driver);
        driver .get("https://www.facebook.com");
        driver .findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click() ;
        Faker faker = new Faker();
        String fakeMail=faker.internet() .emailAddress() ;  //bir dha giriş isterse her defasında aynı mail adresi yazılsın diye


        actions .click(driver .findElement(By.xpath("(//input[@type='text'])[2]")) ) .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB )
                .sendKeys(faker .name() .lastName() ) .sendKeys(Keys.TAB ) .sendKeys(fakeMail).sendKeys(Keys.TAB).sendKeys(fakeMail).sendKeys(Keys.TAB).sendKeys(faker.internet() .password()).
                perform();


    }
}
