package coursera.javastudy1.week1;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarCipher {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key) {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.alphabet = alphabet + alphabet.toLowerCase();
        this.shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
        this.mainKey = key;
    }

    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }

    private String transform(String input, String from, String to) {
        StringBuilder sb =  new StringBuilder(input);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);

        }
        return sb.toString();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if(idx != -1) {
            c = to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }
    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }


    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }

}
