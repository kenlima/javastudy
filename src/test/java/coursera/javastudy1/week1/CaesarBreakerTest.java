package coursera.javastudy1.week1;

import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016. 2. 29..
 */
public class CaesarBreakerTest {

    @Test
    public void testDecrypt() throws Exception {
        FileResource fr = new FileResource("week4/VigenereTestData/titus-small_key5.txt");

        CaesarBreaker cb = new CaesarBreaker();
        String ret = cb.decrypt(fr.asString());
        System.out.println(ret);

        FileResource fr2 = new FileResource("week4/VigenereTestData/oslusiadas.txt");

        CaesarBreaker cb2 = new CaesarBreaker('a');
        String ret2 = cb2.decrypt(fr2.asString());
        System.out.println(ret2);
    }
}