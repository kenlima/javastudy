package coursera.javastudy1.week2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jwlee on 2016-02-10.
 */
public class CodonCount {
    private HashMap<String, Integer> codonMap = new HashMap<>();
    public static final int CODON_SIZE = 3;

    public void buildCodonMap(int start, String dna) {
        codonMap.clear();
        dna = dna.toUpperCase();

        for (int i = start; i < dna.length(); i = i + CODON_SIZE) {
            int end = i + CODON_SIZE;
            if (end > dna.length() - 1) {
                break;
            }
            String codon = dna.substring(i, end);
            if (codonMap.containsKey(codon)) {
                codonMap.put(codon, codonMap.get(codon) + 1);
            } else {
                codonMap.put(codon, 1);
            }
        }

        System.out.println("Reading frame starting with " + start + " results in " + codonMap.size());

        String mostCoddon = getMostCommonCodon();
        System.out.println("And most common codon is " + mostCoddon + " with count " + codonMap.get(mostCoddon));

        printCodonCounts(1, 5);

    }

    public String getMostCommonCodon() {
        /*
        int maxFreqs = 0;
        String maxCodon = "";
        for (Map.Entry<String, Integer> entry : codonMap.entrySet()) {
            if (entry.getValue() > maxFreqs) {
                maxFreqs = entry.getValue();
                maxCodon = entry.getKey();
            }
        }
        */

        String maxCodon = codonMap.keySet().stream()
                .max((key1, key2) -> Integer.compare(codonMap.get(key1), codonMap.get(key2)))
                .get();

        return maxCodon;
    }

    public void printCodonCounts(int start, int end) {

        /*
        for(String key : codonMap.keySet()) {
            if(codonMap.get(key) >= start && codonMap.get(key) <= end) {
                System.out.println(key + " : " + codonMap.get(key));
            }
        }

        */
        codonMap.keySet().stream()
                .filter(key -> codonMap.get(key) >= start && codonMap.get(key) <= end)
                .forEach(key -> System.out.println(key + " : " + codonMap.get(key)));
    }

}
