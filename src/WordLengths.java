import edu.duke.FileResource;
import org.junit.Test;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts) {
        StringBuilder[] words = new StringBuilder[counts.length];

        for(String word : resource.words()) {
            StringBuilder sb = new StringBuilder(word);
            char first = sb.charAt(0);
            char last = sb.charAt(word.length()-1);
            if(!Character.isLetter(first)) {
                sb.delete(0, 1);
            }
            if(!Character.isLetter(last)) {
                sb.deleteCharAt(sb.length()-1);
            }
            int k = sb.length();
            counts[k] += 1;

            if(words[k] == null) {
                words[k] = sb;
            }else {
                words[k].append(", ").append(sb.toString());
            }
        }

        for(int i=0;i<counts.length;i++) {
            if(counts[i] > 0) {
                System.out.println(counts[i] + " words of length " + i + " : " + words[i]);
            }
        }

        int maxIdx = indexOfMax(counts);
        System.out.println("Max Index : " + maxIdx);
    }


    public int indexOfMax(int[] values) {
        int maxIdx = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[maxIdx] < values[i]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }


    @Test
    public void testCountWordLengths() {
        WordLengths wordLengths = new WordLengths();
        int[] counts = new int[31];
        wordLengths.countWordLengths(new FileResource("lotsOfWords.txt"), counts);
    }



}
