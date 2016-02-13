package coursera.javastudy1.week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by jwlee on 2016-02-13.
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;

    public WordsInFiles() {
        map = new HashMap<>();
    }

    private void addWordFormFile(File f) {


        FileResource fr = new FileResource(f);
        for (String word : fr.words()) {
            if (map.containsKey(word)) {
                ArrayList<String> fns = map.get(word);
                if (!fns.contains(f.getName())) {
                    fns.add(f.getName());
                }
            } else {
                ArrayList<String> fns = new ArrayList<>();
                fns.add(f.getName());
                map.put(word, fns);
            }
        }
    }

    public void buildWordFileMap() {
        map.clear();
        DirectoryResource re = new DirectoryResource();
        for (File f : re.selectedFiles()) {
            addWordFormFile(f);
        }
    }

    public int maxNumber() {
        int maxNum = 0;
        for (String word : map.keySet()) {
            int curNum = map.get(word).size();
            if (maxNum < curNum) {
                maxNum = curNum;
            }
        }
        return maxNum;
    }

    public ArrayList<String> wordsInFiles(int number) {
        ArrayList<String> words = new ArrayList<>();
        for (String word : map.keySet()) {
            int size = map.get(word).size();
            if (number == size) {
                words.add(word);
            }
        }
        return words;
    }

    public void printFileIn(String word) {
        String files = map.get(word).stream().collect(Collectors.joining(", "));
        System.out.println(word + " : " + files);

    }

    public void printAllItemsInMap() {
        for(String word : map.keySet()) {
            System.out.println(word);
            System.out.println("\t" + map.get(word).stream().collect(Collectors.joining(", ")));
        }
    }


}
