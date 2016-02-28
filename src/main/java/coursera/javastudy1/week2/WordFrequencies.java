package coursera.javastudy1.week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jwlee on 2016-02-08.
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    private HashMap<String, ArrayList<String>> map;

    public WordFrequencies() {
        this.myWords = new ArrayList<>();
        this.myFreqs = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        //FileResource resource = new FileResource();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);

            for (String word : fr.words()) {
                word = word.toLowerCase();
                if (!myWords.contains(word)) {
                    myWords.add(word);
                    myFreqs.add(1);
                } else {
                    int idx = myWords.indexOf(word);
                    int counts = myFreqs.get(idx);
                    myFreqs.set(idx, counts + 1);
                }


                if (map.containsKey(word)) {
                    ArrayList<String> files = map.get(word);
                    if (!files.contains(f.getName())) {
                        files.add(f.getName());
                    }
                } else {
                    ArrayList<String> files = new ArrayList<>();
                    files.add(f.getName());
                    map.put(word, files);
                }
            }
        }


        System.out.println("Number of unique words : " + myWords.size());

        /*
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        */
    }

    public int getNumberOfWords() {
        return map.keySet().size();
    }

    public int numWordsInFiles(int num) {
        int sum = 0;
        for (ArrayList<String> values : map.values()) {
            if (num == values.size()) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public void printFileNotAppearWord(String word) {
        map.get(word).forEach(System.out::println);
    }

    public int findIndexOfMax() {
        int maxIdx = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(maxIdx) < myFreqs.get(i)) {
                maxIdx = i;
            }
        }
        System.out.println(myWords.get(maxIdx) + ", " + myFreqs.get(maxIdx) + " counts");
        return myFreqs.get(maxIdx);
    }


}
