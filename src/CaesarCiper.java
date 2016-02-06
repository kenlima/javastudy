import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jwlee on 2016-02-06.
 */
public class CaesarCiper {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        System.out.println(shiftedAlphabet);

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

    public String encryptTwoKeys(String input, int key1, int key2) {

        StringBuilder oddStr = new StringBuilder();
        StringBuilder evenStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                oddStr.append(input.charAt(i));
            }else{
                evenStr.append(input.charAt(i));
            }
        }

        String encryptedOddStr = encrypt(oddStr.toString(), key1);
        String encryptedEvenStr = encrypt(evenStr.toString(), key2);

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < encryptedOddStr.length();i++) {
            ret.append(encryptedOddStr.charAt(i));

            if(i < encryptedEvenStr.length()) {
                ret.append(encryptedEvenStr.charAt(i));
            }

        }
        return ret.toString();
    }

    @Test
    public void testEncrypt() throws Exception {
        int key = 17;
        /*
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
        */

        String ret = encrypt("First Legion", 23);
        System.out.println(ret);

        ret = encrypt("First Legion", 17);
        System.out.println(ret);
    }

    @Test
    public void testEncryptTwoKeys() throws Exception {
        String ret = encryptTwoKeys("First Legion",23, 17);
        System.out.println(ret);
    }
}
