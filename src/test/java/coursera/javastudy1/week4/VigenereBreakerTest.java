package coursera.javastudy1.week4;

import org.junit.Test;

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
}