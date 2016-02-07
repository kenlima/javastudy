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


}
