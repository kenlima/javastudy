package coursera.javastudy1.week4;

import coursera.javastudy1.week1.CaesarBreaker;
import edu.duke.FileResource;

import java.util.Arrays;
import java.util.HashSet;

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
        for (int i = 0; i < klength; i++) {
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

        FileResource dic = new FileResource("week4/dictionaries/English");
        HashSet<String> dictionary = readDictionary(dic);

        String ret = breakForLanguage(str, dictionary);

/*
        int[] keys = tryKeyLength(str, 4, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        String ret = vc.decrypt(str);
*/

        System.out.println(ret);
    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> hs = new HashSet<String>();
        for (String line : fr.lines()) {
            line = line.toLowerCase().trim();
            hs.add(line);
        }

        return hs;
    }

    public int countWorks(String message, HashSet<String> dictionary) {
        String[] words = message.split("\\W+");
        int ret = 0;
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                ret += 1;
            }
        }
        return ret;

    }


    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int maxCount = 0;
        String ret = null;
        int[] guessKeys = null;
        for (int i = 1; i <= 100; i++) {
            int[] keys = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(keys);
            String decrypt = vc.decrypt(encrypted);
            int count = countWorks(decrypt, dictionary);
            if (maxCount < count) {
                maxCount = count;
                ret = decrypt;
                guessKeys = keys;
            }

        }
        System.out.println("guess keys : " + Arrays.toString(guessKeys));
        System.out.println("valid words count : " + maxCount);
        return ret;


    }
}
