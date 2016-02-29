package coursera.javastudy1.week4;

import coursera.javastudy1.week1.CaesarCipher;

import java.util.ArrayList;

/**
 * Created by jwlee on 2016. 2. 29..
 */
public class VigenereCipher {

    CaesarCipher[] ciphers;


    public VigenereCipher(int[] keys) {
        ciphers = new CaesarCipher[keys.length];
        for (int i = 0; i < keys.length; i++) {
            ciphers[i] = new CaesarCipher(keys[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = input.toCharArray();
        int i = 0;
        for (char c : input.toCharArray()) {
            int keyIdx = i % ciphers.length;
            CaesarCipher cc = ciphers[keyIdx];
            sb.append(cc.encryptLetter(c));
            i++;
        }
        return sb.toString();
    }

    public String decrypt(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int keyIdx = i % input.length();
            CaesarCipher cc = ciphers[keyIdx];
            sb.append(cc.decryptLetter(c));
            i++;
        }
        return sb.toString();
    }
}
