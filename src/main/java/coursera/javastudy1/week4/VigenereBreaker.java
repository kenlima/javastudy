package coursera.javastudy1.week4;

import coursera.javastudy1.week1.CaesarBreaker;
import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
//        FileResource fr = new FileResource("week4/VigenereTestData/athens_keyflute.txt");
        FileResource fr = new FileResource("week4/secretmessage4.txt");
        String encrypted = fr.asString();


        HashMap<String, HashSet<String>> dictionaries = new HashMap<>();

        List<String> list = Arrays.asList("week4/dictionaries/Danish",
                "week4/dictionaries/Dutch",
                "week4/dictionaries/English",
                "week4/dictionaries/French",
                "week4/dictionaries/German",
                "week4/dictionaries/Italian",
                "week4/dictionaries/Portuguese",
                "week4/dictionaries/Spanish");
        for(String fname : list) {
            FileResource dic = new FileResource(fname);
            HashSet<String> dictionary = readDictionary(dic);
            dictionaries.put(fname, dictionary);
            System.out.println("Loaded " + fname + " dictionary.");

        }

        System.out.println("Loaded All dictionaries");

        breakForAllLanguages(encrypted, dictionaries);

/*
        int[] keys = tryKeyLength(str, 4, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        String ret = vc.decrypt(str);
*/

    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> hs = new HashSet<String>();
        for (String line : fr.lines()) {
            line = line.toLowerCase().trim();
            hs.add(line);
        }
        return hs;
    }

    public int countWords(String message, HashSet<String> dictionary) {
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
        int totalCount = 0;
        String ret = null;
        int[] guessKeys = null;
        char mostChar = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++) {
            int[] keys = tryKeyLength(encrypted, i, mostChar);
            VigenereCipher vc = new VigenereCipher(keys);
            String decrypt = vc.decrypt(encrypted);
            int count = countWords(decrypt, dictionary);
            if (maxCount < count) {
                totalCount = decrypt.split("\\W+").length;
                maxCount = count;
                ret = decrypt;
                guessKeys = keys;
            }

        }
        System.out.println("guess keys : " + Arrays.toString(guessKeys));
        System.out.println("guess keys length : " + guessKeys.length);
        System.out.println("valid words count : " + maxCount + ", " + totalCount);
        System.out.println("most common char : " + mostChar);
        System.out.println(ret.substring(0, ret.indexOf("\n")));
        return ret;


    }

    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<String, Integer> chars = new HashMap<>();
        for (String s : dictionary) {
            char[] cs = s.toCharArray();
            for (char c : cs) {
                String ch = String.valueOf(c);
                if (chars.containsKey(ch)) {
                    chars.put(ch, chars.get(ch) + 1);
                } else {
                    chars.put(ch, 1);
                }
            }
        }

        String mostCh = chars.keySet().stream().max((c1, c2) -> Integer.compare(chars.get(c1), chars.get(c2))).get();
        return mostCh.charAt(0);
    }

    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages) {
        for (String language : languages.keySet()) {
            System.out.println("breaking cypher by " + language);
            String ret = breakForLanguage(encrypted, languages.get(language));
//            System.out.println(ret);
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }

    }


}
