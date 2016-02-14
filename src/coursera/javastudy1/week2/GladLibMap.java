package coursera.javastudy1.week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.URLResource;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private Random myRandom;
    private ArrayList<String> usedList;
    private ArrayList<String> consideredCategories;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap() {
        myMap = new HashMap<>();
        myRandom = new Random();
        usedList = new ArrayList<>();
        consideredCategories = new ArrayList<>();
        initializeFromSource(dataSourceDirectory);
    }

    public GladLibMap(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String[] keys = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "fruit", "verb"};

        for (String key : keys) {
            myMap.put(key, readIt(source + "/" + key + ".txt"));
        }
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {

        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        } else if(myMap.containsKey(label)) {
            consideredCategories.add(label);
            return randomFrom(myMap.get(label));
        }

        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        System.out.println(w);
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);

        String sub = null;
        do {
            sub = getSubstitute(w.substring(first + 1, last));
        } while (usedList.contains(sub));

        usedList.add(sub);
        System.out.println(sub);
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }

        System.out.println("unique word : " + usedList);
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
    }

    public int totalWordsInMap() {
        //int total = myMap.values().stream().map(list -> list.size()).mapToInt(Integer::new).sum();
        int total = myMap.values().stream().map(list -> list.size()).reduce((x, y) -> x + y).get();

        return total;
    }

    public int totalWordsConsidered() {
        int sumNumber = 0;
        for(String category : consideredCategories) {
            int s = myMap.get(category).size();
            sumNumber = sumNumber + s;
        }
        return sumNumber;
    }
}
