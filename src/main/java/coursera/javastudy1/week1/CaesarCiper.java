package coursera.javastudy1.week1;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarCiper {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCiper(int key) {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        this.mainKey = key;
    }

    public String encrypt(String input) {
        StringBuilder encrypted =  new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                if(Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }

                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }


    public String decrypt(String input) {
        CaesarCiper cc = new CaesarCiper(26-mainKey);
        return cc.encrypt(input);
    }

}
