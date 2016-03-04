package coursera.javastudy1.week4;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016. 3. 1..
 */
public class VigenereBreakerTest {

    @Test
    public void testSliceString() throws Exception {
        VigenereBreaker vb = new VigenereBreaker();
        String ret = vb.sliceString("abcdefghijklm", 0, 3);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 1, 3);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 2, 3);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 0, 4);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 1, 4);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 2, 4);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 3, 4);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 0, 5);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 1, 5);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 2, 5);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 3, 5);
        System.out.println(ret);

        ret = vb.sliceString("abcdefghijklm", 4, 5);
        System.out.println(ret);
    }

    @Test
    public void testTryKeyLength() throws Exception {
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        int[] rets = vb.tryKeyLength(fr.asString(), 4, 'e');

        for (int ret : rets) {
            System.out.println(ret);
        }


    }

    @Test
    public void testBreakVigenere() throws Exception {

        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere();
    }

    @Test
    public void testReadDictionary() throws Exception {

        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        HashSet<String> hs = vb.readDictionary(fr);
        System.out.println(hs);
    }
}