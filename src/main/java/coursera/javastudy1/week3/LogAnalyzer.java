package coursera.javastudy1.week3;
/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }

    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }


    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            if (!uniqueIPs.contains(le.getIpAddress())) {
                uniqueIPs.add(le.getIpAddress());
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            if (num < le.getStatusCode()) {
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getAccessTime().toString().indexOf(someday) > -1) {
                if (!uniqueIPs.contains(le.getIpAddress())) {
                    uniqueIPs.add(le.getIpAddress());
                }

            }
        }
        return uniqueIPs;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getStatusCode() >= low && le.getStatusCode() <= high) {
                if (!uniqueIPs.contains(le.getIpAddress())) {
                    uniqueIPs.add(le.getIpAddress());
                }
            }
        }
        return uniqueIPs.size();
    }


    public void printUniqueStatus(int num) {
        ArrayList<Integer> uniqueStatuses = new ArrayList<>();
        for (LogEntry le : records) {
            if (num < le.getStatusCode()) {
                if (!uniqueStatuses.contains(le.getStatusCode())) {
                    uniqueStatuses.add(le.getStatusCode());
                }
            }
        }
        System.out.println(uniqueStatuses);
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> map = new HashMap<>();

        for (LogEntry le : records) {
            if (map.containsKey(le.getIpAddress())) {
                map.put(le.getIpAddress(), map.get(le.getIpAddress()) + 1);
            } else {
                map.put(le.getIpAddress(), 1);
            }
        }
        return map;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
        int maxNum = 0;
        for (String ip : map.keySet()) {
            if (maxNum < map.get(ip)) {
                maxNum = map.get(ip);
            }
        }
        return maxNum;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map) {
        int maxNum = mostNumberVisitsByIP(map);
        ArrayList<String> maxIPs = new ArrayList<>();

        for (String ip : map.keySet()) {
            if (maxNum == map.get(ip)) {
                maxIPs.add(ip);
            }
        }
        return maxIPs;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
            String key = le.getAccessTime().toString().substring(4, 10);
            if (map.keySet().contains(key)) {
                map.get(key).add(le.getIpAddress());
            } else {
                ArrayList ips = new ArrayList<String>();
                ips.add(le.getIpAddress());
                map.put(key, ips);
            }
        }
        return map;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
        int maxNum = 0;
        for (String key : map.keySet()) {
            if (maxNum < map.get(key).size()) {
                maxNum = map.get(key).size();
            }
        }

        for (String key : map.keySet()) {
            if (maxNum == map.get(key).size()) {
                return key;
            }
        }
        return "";
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String onDay) {
        ArrayList<String> ips = null;
        for(String key : map.keySet()) {
            if(onDay.equals(key)) {
               ips = map.get(key);
            }
        }
        HashMap<String, Integer> countPerIp = new HashMap<String, Integer> ();
        for(String ip : ips) {
            if(countPerIp.containsKey(ip)) {
                countPerIp.put(ip, countPerIp.get(ip) + 1);
            } else {
                countPerIp.put(ip, 1);
            }
        }

        ArrayList<String> mostIps = iPsMostVisits(countPerIp);

        return mostIps;
    }

}
