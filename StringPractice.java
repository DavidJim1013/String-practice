import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPractice {
    public static void main(String[] args) {
        String input1 = "abcd123.456";
        String input2 = "abcd123";

        System.out.println(extractNumber(input1));
        System.out.println(extractNumber(input2));
    }

    public static String extractNumber(String input) {
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String numStr = matcher.group(1);
            if (numStr.contains(".")) {
                int dotIndex = numStr.indexOf('.');
                if (dotIndex + 3 < numStr.length()) {
                    numStr = numStr.substring(0, dotIndex + 3);
                } else if (dotIndex + 2 == numStr.length()) {
                    numStr += "0";
                }
            } else {
                numStr += ".00";
            }
            return numStr;
        }
        return "";
    }
}
