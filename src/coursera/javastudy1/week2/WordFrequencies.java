package coursera.javastudy1.week2;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jwlee on 2016-02-08.
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
       this.myWords = new ArrayList<>();
        this.myFreqs = new ArrayList<>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String word : resource.words()) {
            word = word.toLowerCase();
            if(!myWords.contains(word)) {
                myWords.add(word);
                myFreqs.add(1);
            }else{
                int idx = myWords.indexOf(word);
                int counts = myFreqs.get(idx);
                myFreqs.set(idx, counts + 1);
            }
        }

        System.out.println("Number of unique words : " + myWords.size());

        /*
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        */
    }

    public int findIndexOfMax() {
        int maxIdx = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if(myFreqs.get(maxIdx) < myFreqs.get(i)) {
                maxIdx = i;
            }
        }
        System.out.println(myWords.get(maxIdx) + ", " + myFreqs.get(maxIdx) + " counts");
        return myFreqs.get(maxIdx);
    }

    @Test
    public void testFindUnique() throws Exception {
        WordFrequencies wf = new WordFrequencies();
        wf.findUnique();
        System.out.println("The word that occurs most often and its count are : " +wf.findIndexOfMax());
    }
}
