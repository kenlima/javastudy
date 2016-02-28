package coursera.javastudy1.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jwlee on 2016. 2. 28..
 */
public class LogAnalyzerTest {

    @Test
    public void testPrintAll() throws Exception {

        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/short-test_log");
        la.printAll();
    }

    @Test
    public void testReadFile() throws Exception {

    }

    @Test
    public void testCountUniqueIPs() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        int counts = la.countUniqueIPs();
        System.out.println(counts);

    }

    @Test
    public void testPrintAllHigherThanNum() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog1_log");
        la.printAllHigherThanNum(400);
        la.printUniqueStatus(400);


    }

    @Test
    public void testUniqueIPVisitsOnDay() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog-short_log");
        ArrayList<String> result = la.uniqueIPVisitsOnDay("Sep 14");
        System.out.println(result);
        ArrayList<String> result2 = la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println(result2);

        la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        result = la.uniqueIPVisitsOnDay("Sep 27");
        System.out.println(result.size());


    }

    @Test
    public void testCountUniqueIPsInRange() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        int result = la.countUniqueIPsInRange(400, 499);
        System.out.println(result);

    }

    @Test
    public void testPrintUniqueStatus() throws Exception {

    }

    @Test
    public void testCountVisitsPerIP() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog3-short_log");
        HashMap<String, Integer> map = la.countVisitsPerIP();
        System.out.println(map);
    }

    @Test
    public void testMostNumberVisitsByIP() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        int maxNum  = la.mostNumberVisitsByIP(la.countVisitsPerIP());
        System.out.println(maxNum);

    }

    @Test
    public void testIPsMostVisits() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        ArrayList<String> ips = la.iPsMostVisits(la.countVisitsPerIP());
        System.out.println(ips);
    }

    @Test
    public void testIPsForDays() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog3-short_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println(map);

    }

    @Test
    public void testDayWithMostIPVisits() throws Exception {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        String mostDay = la.dayWithMostIPVisits(la.iPsForDays());
        System.out.println(mostDay);
    }

    @Test
    public void testIPsWithMostVisitsOnDay() throws Exception {

        LogAnalyzer la = new LogAnalyzer();
        la.readFile("week3/weblog2_log");
        ArrayList<String> result = la.iPsWithMostVisitsOnDay(la.iPsForDays(), "Sep 30");
        System.out.println(result);
    }
}