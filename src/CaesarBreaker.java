import org.junit.Test;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarBreaker {
    public String decrypt(String encrypted) {
        CaesarCiper cc = new CaesarCiper();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4; // guess encrypted key
        if(maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }

        return cc.encrypt(encrypted, 26-dkey);
    }

    private int maxIndex(int[] freqs) {
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
        CaesarCiper cc = new CaesarCiper();
        String ret = cc.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees", 5);
        System.out.println(ret);

        CaesarBreaker cb = new CaesarBreaker();
        ret = cb.decrypt(ret);
        System.out.println(ret);

    }
}
