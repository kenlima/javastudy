import org.junit.Test;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarCiperTwoTest {



    @Test
    public void testEncryptTwoKeys() throws Exception {
        CaesarCiperTwo cct = new CaesarCiperTwo(23, 17);
        String ret = cct.encryptTwoKeys("First Legion");
        System.out.println(ret);
    }
}
