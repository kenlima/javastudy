package coursera.javastudy1.week2;

import edu.duke.FileResource;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016-02-10.
 */
public class CodonCountTest {

    @Test
    public void testPrintCodonCounts() throws Exception {
        FileResource fr = new FileResource("dnaMystery1.txt");
        String dna = fr.asString();

        CodonCount cc = new CodonCount();
        //cc.buildCodonMap(0, dna);

        cc.buildCodonMap(1, dna);
        cc.printCodonCounts(1, 6);

        //cc.buildCodonMap(2, dna);
        //cc.printCodonCounts(1, 6);
    }
}