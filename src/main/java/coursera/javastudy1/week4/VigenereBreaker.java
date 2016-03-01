package coursera.javastudy1.week4;

/**
 * Created by jwlee on 2016. 3. 1..
 */
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i = i + totalSlices) {
            char c = message.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
}
