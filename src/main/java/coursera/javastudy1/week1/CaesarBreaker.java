package coursera.javastudy1.week1;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarBreaker {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int mostCommonLetterIdx;

    public CaesarBreaker() {
        mostCommonLetterIdx = ALPHABET.indexOf('e');
    }

    public CaesarBreaker(char mostCommonLetter) {
        mostCommonLetterIdx = ALPHABET.indexOf(mostCommonLetter);
    }

    public String decrypt(String encrypted) {
        int dKey = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(26 - dKey);

        return cc.encrypt(encrypted);
    }

    public int getKey(String encrypted) {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - mostCommonLetterIdx; // guess encrypted key
        if (maxDex < mostCommonLetterIdx) {
            dKey = 26 - (mostCommonLetterIdx - maxDex);
        }
        return dKey;
    }


    public int maxIndex(int[] freqs) {
        int maxIdx = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] > freqs[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private int[] countLetters(String encrypted) {
        String alphabet = ALPHABET;
        int[] counts = new int[26];

        for (int i = 0; i < encrypted.length(); i++) {
            char ch = Character.toLowerCase(encrypted.charAt(i));
            int dex = alphabet.indexOf(ch);

            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
}
