package coursera.javastudy1.week2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016-02-13.
 */
public class WordsInFilesTest {

    @Test
    public void testBuildWordFileMap() throws Exception {
        WordsInFiles wif = new WordsInFiles();

        wif.buildWordFileMap();
        int maxNum = wif.maxNumber();
        System.out.println("maxNum : " +maxNum );

        ArrayList<String> files = wif.wordsInFiles(maxNum);
        files.forEach(word -> wif.printFileIn(word));

        wif.printAllItemsInMap();
    }
}