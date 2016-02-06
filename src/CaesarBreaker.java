import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarBreaker {
    public String decrypt(String encrypted) {
        CaesarCiper cc = new CaesarCiper();
        int dKey = getKey(encrypted);

        return cc.encrypt(encrypted, 26-dKey);
    }

    private int getKey(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4; // guess encrypted key
        if(maxDex < 4) {
            dKey = 26 - (4-maxDex);
        }
        return dKey;
    }

    public String decryptTwoKeys(String encrypted) {
        String oddStr = halfOfString(encrypted, 0);
        String evenStr = halfOfString(encrypted, 1);

        int key1 = getKey(oddStr);
        System.out.println("key1 is " + key1);
        int key2 = getKey(evenStr);
        System.out.println("key2 is " + key2);

        CaesarCiper cc = new CaesarCiper();
        String ret = cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);


        return ret;

    }

    public String halfOfString(String message, int start) {
        StringBuilder halfOfStr = new StringBuilder();
        for (int i = start; i < message.length(); i+=2) {
            halfOfStr.append(message.charAt(i));
        }
        return halfOfStr.toString();
    }


    public int maxIndex(int[] freqs) {
        int maxIdx = 0;
        for (int i = 0; i < freqs.length; i++) {
            if(freqs[i] > freqs[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private int[] countLetters(String encrypted) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];

        for (int i = 0; i < encrypted.length(); i++) {
            char ch = Character.toLowerCase(encrypted.charAt(i));
            int dex = alphabet.indexOf(ch);

            if(dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    @Test
    public void testHalfOfString() {
        CaesarBreaker cb = new CaesarBreaker();
        String ret = cb.halfOfString("Qbkm Zgis", 0);
        assertEquals("Qk gs", ret);

        ret = cb.halfOfString("Qbkm Zgis", 1);
        assertEquals("bmZi", ret);
    }

    @Test
    public void testDecrypt() {
        CaesarCiper cc = new CaesarCiper();
        String ret = cc.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees", 5);
        System.out.println(ret);

        CaesarBreaker cb = new CaesarBreaker();
        ret = cb.decrypt(ret);
        System.out.println(ret);

    }

    @Test
    public void testDecryptTwoKeys() {
        CaesarBreaker cb = new CaesarBreaker();
        String ret = cb.decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println(ret);
    }
}
