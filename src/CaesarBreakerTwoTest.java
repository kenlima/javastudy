import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarBreakerTwoTest {


    @Test
    public void testHalfOfString() {
        CaesarBreakerTwo cbt = new CaesarBreakerTwo();
        String ret = cbt.halfOfString("Qbkm Zgis", 0);
        assertEquals("Qk gs", ret);

        ret = cbt.halfOfString("Qbkm Zgis", 1);
        assertEquals("bmZi", ret);
    }


    @Test
    public void testDecryptTwoKeys() {
        CaesarBreakerTwo cbt = new CaesarBreakerTwo();
        String ret = cbt.decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println(ret);

        CaesarCiperTwo cc = new CaesarCiperTwo(26-2, 26-20);
        ret = cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(ret);

        FileResource resource = new FileResource("mysteryTwoKeysPractice.txt");
        ret = cbt.decryptTwoKeys(resource.asString());
        System.out.println(ret);
    }
}
