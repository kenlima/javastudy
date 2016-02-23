package coursera.javastudy1.week2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwlee on 2016-02-09.
 */
public class CharactersInPlayTest {

    @Test
    public void testFindAllCharacters() throws Exception {
        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters();
        System.out.println("=====");
        cip.charactersWithNumParts(10, 15);
        System.out.println("=====");
        cip.characterWithMostSpeakingPart();
    }
}