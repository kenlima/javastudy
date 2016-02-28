package coursera.javastudy1.week1;

import org.junit.Test;

/**
 * Created by jwlee on 2016-02-07.
 */
public class CaesarCiperTwo {

    private int key1;
    private int key2;

    public CaesarCiperTwo(int key1, int key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encryptTwoKeys(String input) {

        StringBuilder oddStr = new StringBuilder();
        StringBuilder evenStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(i % 2 == 0) {
                oddStr.append(input.charAt(i));
            }else{
                evenStr.append(input.charAt(i));
            }
        }

        CaesarCiper cc1 = new CaesarCiper(key1);
        CaesarCiper cc2 = new CaesarCiper(key2);
        String encryptedOddStr = cc1.encrypt(oddStr.toString());
        String encryptedEvenStr = cc2.encrypt(evenStr.toString());

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < encryptedOddStr.length();i++) {
            ret.append(encryptedOddStr.charAt(i));

            if(i < encryptedEvenStr.length()) {
                ret.append(encryptedEvenStr.charAt(i));
            }

        }
        return ret.toString();
    }


}
