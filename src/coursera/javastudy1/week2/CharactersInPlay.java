package coursera.javastudy1.week2;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jwlee on 2016-02-09.
 */
public class CharactersInPlay {
    private ArrayList<String> chars = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    public void update(String person) {
        int currIdx = chars.indexOf(person);
        if (currIdx != -1) {
            counts.set(currIdx, counts.get(currIdx) + 1);
        } else {
            chars.add(person);
            counts.add(1);
        }
    }

    public void findAllCharacters() {
        chars.clear();
        counts.clear();

        FileResource fr = new FileResource();
        for (String line : fr.lines()) {

            int idx = line.indexOf('.');
            if (idx != -1) {
                update(line.substring(0, idx).trim());
            }

        }

        for (int i = 0; i < chars.size(); i++) {
            System.out.println(chars.get(i) + " : " + counts.get(i));
        }
    }

    public void characterWithMostSpeakingPart() {
        int maxIdx = 0;
        for (int i = 0; i < counts.size(); i++) {
            if(counts.get(maxIdx) < counts.get(i)) {
                maxIdx = i;
            }
        }
        System.out.println("Character with most speaking part : " + chars.get(maxIdx));
        System.out.println("counts of character : " + counts.get(maxIdx));
    }

    public void charactersWithNumParts(int num1, int num2) {
        for (int i = 0; i < counts.size(); i++) {
            if(counts.get(i) >= num1 && counts.get(i) <= num2) {
                System.out.println(chars.get(i) + " : " + counts.get(i));
            }
        }
    }

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
