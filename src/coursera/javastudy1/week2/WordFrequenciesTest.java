package coursera.javastudy1.week2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016-02-08.
 */
public class WordFrequenciesTest {
    @Test
    public void testFindUnique() throws Exception {
        WordFrequencies wf = new WordFrequencies();
        wf.findUnique();
        System.out.println("The word that occurs most often and its count are : " +wf.findIndexOfMax());
        //System.out.println(wf.getNumberOfWords());


        int ret = wf.numWordsInFiles(4);
        System.out.println("number of unique word in files : " + ret);


        wf.printFileNotAppearWord("red");


    }

}