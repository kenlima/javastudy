package coursera.javastudy1.week1;

import org.junit.Test;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarCiperTwoTest {



    @Test
    public void testEncryptTwoKeys() throws Exception {
        CaesarCiperTwo cct = new CaesarCiperTwo(21, 8);
        String ret = cct.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println(ret);

        cct = new CaesarCiperTwo(26-14, 26-24);
        ret = cct.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");
        System.out.println(ret);
    }
}
