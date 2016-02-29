package coursera.javastudy1.week4;

import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016. 2. 29..
 */
public class VigenereCipherTest {

    @Test
    public void testEncrypt() throws Exception {

        int[] keys = new int[] {17, 14, 12, 4};
        FileResource fr = new FileResource("week4/VigenereTestData/titus-small.txt");

        VigenereCipher vc = new VigenereCipher(keys);
        String encrypted = vc.encrypt(fr.asString());
        System.out.println(encrypted);
    }


    @Test
    public void testDecrypt() throws Exception {

    }
}