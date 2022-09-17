package day12_Senkronizasyon;

import org.junit.Test;
import utilities.TestBase;

public class C02_ExpilicitlyWait extends TestBase {
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void is_enable_testi() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver .get("https://the-internet.herokuapp.com/dynamic_controls") ;
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    }
}
