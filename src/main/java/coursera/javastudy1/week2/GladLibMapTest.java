package coursera.javastudy1.week2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016-02-13.
 */
public class GladLibMapTest {

    @Test
    public void testMakeStory() throws Exception {
        GladLibMap glm = new GladLibMap();
        glm.makeStory();
        int totalNumber = glm.totalWordsInMap();
        System.out.println(totalNumber);

        int consideredNum = glm.totalWordsConsidered();
        System.out.println("Considered total number : " + consideredNum);
    }
}