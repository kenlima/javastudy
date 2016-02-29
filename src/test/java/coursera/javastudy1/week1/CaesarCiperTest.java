package coursera.javastudy1.week1;

import edu.duke.FileResource;
import org.junit.Test;

/**
 * Created by jwlee on 2016. 2. 29..
 */
public class CaesarCiperTest {

    @Test
    public void testEncrypt() throws Exception {

        FileResource fr = new FileResource("week4/VigenereTestData/titus-small.txt");
        CaesarCipher cc = new CaesarCipher(5);
        String result = cc.encrypt(fr.asString());
        System.out.println("encrytped : " + result);
        String decrypted = cc.decrypt(result);
        System.out.println("decrytped : " + decrypted);

    }

    @Test
    public void simpleTests() throws Exception {
        /*
        FileResource resource = new FileResource();
        String input = resource.asString();
        */

        CaesarCipher cc = new CaesarCipher(15);
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