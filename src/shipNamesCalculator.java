import java.io.IOException;
import java.util.ArrayList;

public class shipNamesCalculator {

    private String name1;
    private String name2;

    private char[] name1CharArr;
    private char[] name2CharArr;

    private String longerName;
    private char[] longerNameArr;

    private String shorterName;
    private char[] shorterNameArr;

    private String computeType;

    public shipNamesCalculator(String name1, String name2, String computeType) {
        this.name1 = name1;
        this.name2 = name2;
        this.computeType = computeType;
    }

    public void run() throws IOException {
        methodHandler();
    }

    public void methodHandler() throws IOException {
        convertNamesToArray(name1, name2);
        longerAndShorterName();
        produceNameCombinations();
    }

    public void convertNamesToArray(String name1, String name2) {
        char[] name1CharArray = new char[name1.length()];
        char[] name2CharArray = new char[name2.length()];

        for (int i = 0; i < name1.length(); i++) {
            name1CharArray[i] = name1.charAt(i);
        }
        for (int i = 0; i < name2.length(); i++) {
            name2CharArray[i] = name2.charAt(i);
        }
        this.name1CharArr = name1CharArray;
        this.name2CharArr = name2CharArray;
    }

    public void longerAndShorterName() {
        if (name1.length() < name2.length()) {
            shorterName = name1;
            shorterNameArr = name1CharArr;
            longerName = name2;
            longerNameArr = name2CharArr;
        } else if (name2.length() < name1.length()) {
            shorterName = name2;
            shorterNameArr = name2CharArr;
            longerName = name1;
            longerNameArr = name1CharArr;
        } else if (name2.length() == name1.length()) {
            shorterName = name1;
            shorterNameArr = name1CharArr;
            longerName = name2;
            longerNameArr = name2CharArr;
        }
    }

    public void produceNameCombinations() throws IOException {
        if (computeType.equals("traditional")) {
            traditionalNameCombinations nc = new traditionalNameCombinations();
            nc.compute(shorterNameArr, longerNameArr);
        } else if (computeType.equals("allPermutations")) {
            allNamePermutations ap = new allNamePermutations(name1, name2);
            ap.run();
        }
    }
}
