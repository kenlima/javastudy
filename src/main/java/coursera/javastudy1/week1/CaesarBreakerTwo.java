package coursera.javastudy1.week1;

import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarBreakerTwo {

    public String decryptTwoKeys(String encrypted) {
        String oddStr = halfOfString(encrypted, 0);
        String evenStr = halfOfString(encrypted, 1);

        CaesarBreaker cb = new CaesarBreaker();
        int key1 = cb.getKey(oddStr);
        System.out.println("key1 is " + key1);
        int key2 = cb.getKey(evenStr);
        System.out.println("key2 is " + key2);

        CaesarCiperTwo cc = new CaesarCiperTwo(26-key1, 26-key2);
        String ret = cc.encryptTwoKeys(encrypted);


        return ret;

    }


    public String halfOfString(String message, int start) {
        StringBuilder halfOfStr = new StringBuilder();
        for (int i = start; i < message.length(); i+=2) {
            halfOfStr.append(message.charAt(i));
        }
        return halfOfStr.toString();
    }

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
        /*
        CaesarBreakerTwo cbt = new CaesarBreakerTwo();
        String ret = cbt.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        System.out.println(ret);
        */
        /*
        CaesarCiperTwo cc = new CaesarCiperTwo(26-2, 26-20);
        ret = cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(ret);
        */


            FileResource resource = new FileResource("mysteryTwoKeysQuiz.txt");
            CaesarBreakerTwo cbt2 = new CaesarBreakerTwo();
            String ret2 = cbt2.decryptTwoKeys(resource.asString());
            System.out.println(ret2);

        }
    }
}
