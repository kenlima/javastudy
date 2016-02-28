package coursera.javastudy1.week1;

import edu.duke.FileResource;
import org.junit.Test;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarCiperTest {

    @Test
    public void testEncrypt() throws Exception {
        int key = 15;
        /*
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
        */

        CaesarCiper cc = new CaesarCiper(key);

        String ret = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println(ret);

        ret = cc.decrypt(ret);

        System.out.println(ret);
    }

    @Test
    public void simpleTests() throws Exception {
        /*
        FileResource resource = new FileResource();
        String input = resource.asString();
        */

        CaesarCiper cc = new CaesarCiper(15);
        String encrypted = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("encrypted : " + encrypted);

        /*
        String decrypted = cc.decrypt(encrypted);
        System.out.println("decrypted : " + decrypted);

        CaesarBreaker cb = new CaesarBreaker();
        String breaked = cb.decrypt(encrypted);
        System.out.println("breaked : " + breaked);
        */
    }
}
