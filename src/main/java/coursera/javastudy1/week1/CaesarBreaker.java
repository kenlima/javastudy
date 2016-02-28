package coursera.javastudy1.week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarBreaker {
    public String decrypt(String encrypted) {
        int dKey = getKey(encrypted);
        CaesarCiper cc = new CaesarCiper(26-dKey);

        return cc.encrypt(encrypted);
    }

    public int getKey(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4; // guess encrypted key
        if(maxDex < 4) {
            dKey = 26 - (4-maxDex);
        }
        return dKey;
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
    public void testDecrypt() {
        CaesarCiper cc = new CaesarCiper(5);
        String ret = cc.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees");
        System.out.println(ret);

        CaesarBreaker cb = new CaesarBreaker();
        ret = cb.decrypt(ret);
        System.out.println(ret);

        ret = cb.decrypt("Akag tjw Xibhr awoa aoee xakex znxag xwko");
        System.out.println(ret);


    }

}
