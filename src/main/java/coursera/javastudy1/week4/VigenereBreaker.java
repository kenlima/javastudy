package coursera.javastudy1.week4;

import coursera.javastudy1.week1.CaesarBreaker;
import edu.duke.FileResource;

/**
 * Created by jwlee on 2016. 3. 1..
 */
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i = i + totalSlices) {
            char c = message.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] keys = new int[klength];
        for(int i=0;i<klength;i++) {
           String sliceStr = sliceString(encrypted, i, klength);
            CaesarBreaker cb = new CaesarBreaker();
            int key = cb.getKey(sliceStr);
            keys[i] = key;
        }
        return keys;
    }

    public void breakVigenere() {
        FileResource fr = new FileResource();
        String str = fr.asString();

        int[] keys = tryKeyLength(str, 4, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        String ret = vc.decrypt(str);

        System.out.println(ret);
    }
}
