import java.util.ArrayList;

public class grammarDatabase {
    private static ArrayList<String[]> invalidLetterPairsArr = new ArrayList<>();
    private static ArrayList<String[]> invalidConsonantPairFollowingsArr = new ArrayList<>();
    private static ArrayList<String[]> awkwardTripletsArr = new ArrayList<>();
    private static ArrayList<String[]> awkwardFourLetterPhrasesArr = new ArrayList<>();
    private static ArrayList<Object[]> analyzedLetterCombosArr = new ArrayList<>();


    public static void addInvalidLetterPair(String letter1, String letter2) {
        String[] currentLetterPairArr = new String[2];
        currentLetterPairArr[0] = letter1;
        currentLetterPairArr[1] = letter2;

        if (!invalidLetterPairsArr.contains(currentLetterPairArr)) {
            invalidLetterPairsArr.add(currentLetterPairArr);
        } else {
            text.newLine();
            text.print("// already  handled //");
            text.newLine();
        }
    }

    public static void addInvalidConsonantPairFollowing(String letter1, String letter2) {
        String[] currentLetterPairArr = new String[2];
        currentLetterPairArr[0] = letter1;
        currentLetterPairArr[1] = letter2;

        if (!invalidConsonantPairFollowingsArr.contains(currentLetterPairArr)) {
            invalidConsonantPairFollowingsArr.add(currentLetterPairArr);
        } else {
            text.newLine();
            text.print("// already  handled //");
            text.newLine();
        }
    }

    public static void addAwkwardTripletsArr(String letter1, String letter2, String letter3) {
        String[] currentLetterPairArr = new String[3];
        currentLetterPairArr[0] = letter1;
        currentLetterPairArr[1] = letter2;
        currentLetterPairArr[2] = letter3;

        if (!awkwardTripletsArr.contains(currentLetterPairArr)) {
            awkwardTripletsArr.add(currentLetterPairArr);
        } else {
            text.newLine();
            text.print("// already  handled //");
            text.newLine();
        }
    }

    public static void addAwkwardFourLetterPhrasesArr(String letter1, String letter2, String letter3, String letter4) {
        String[] currentLetterPairArr = new String[4];
        currentLetterPairArr[0] = letter1;
        currentLetterPairArr[1] = letter2;
        currentLetterPairArr[2] = letter3;
        currentLetterPairArr[3] = letter4;

        if (!awkwardFourLetterPhrasesArr.contains(currentLetterPairArr)) {
            awkwardFourLetterPhrasesArr.add(currentLetterPairArr);
        } else {
            text.newLine();
            text.print("// already  handled //");
            text.newLine();
        }
    }

    public static ArrayList<String[]> getInvalidLetterPairsArr() {
        return invalidLetterPairsArr;
    }

    public static ArrayList<String[]> getInvalidConsonantPairFollowingsArr() {
        return invalidConsonantPairFollowingsArr;
    }

    public static ArrayList<String[]> getAwkwardTripletsArr() {
        return awkwardTripletsArr;
    }

    public static ArrayList<String[]> getAwkwardFourLetterPhrasesArr() {
        return awkwardFourLetterPhrasesArr;
    }

    // ...

    public static void setInvalidLetterPairsArr(ArrayList<String[]> arrList) {
        invalidLetterPairsArr = arrList;
    }

    public static void setInvalidConsonantPairFollowingsArr(ArrayList<String[]> arrList) {
        invalidConsonantPairFollowingsArr = arrList;
    }

    public static void setAwkwardTripletsArr(ArrayList<String[]> arrList) {
        awkwardTripletsArr = arrList;
    }

    public static void setAwkwardFourLetterPhrasesArr(ArrayList<String[]> arrList) {
        awkwardFourLetterPhrasesArr = arrList;
    }

    // ...

    public static void invalidLetterPairsArrRemoveOccurance(String letter1, String letter2) {
        String[] arr = new String[2];
        arr[0] = letter1;
        arr[1] = letter2;


        //invalidLetterPairsArr = arrList;
    }

    public static void invalidConsonantPairFollowingsArrRemoveOccurance(ArrayList<String[]> arrList) {
        invalidConsonantPairFollowingsArr = arrList;
    }

    public static void awkwardTripletsArrRemoveOccurance(ArrayList<String[]> arrList) {
        awkwardTripletsArr = arrList;
    }

    public static void awkwardFourLetterPhrasesArrRemoveOccurance(ArrayList<String[]> arrList) {
        awkwardFourLetterPhrasesArr = arrList;
    }

    // ...

    public static int getInvalidLetterPairsArrLength() {
        return invalidLetterPairsArr.size();
    }

    public static int getInvalidConsonantPairFollowingsArrLength() {
        return invalidConsonantPairFollowingsArr.size();
    }

    public static int getAwkwardTripletsArrLength() {
        return awkwardTripletsArr.size();
    }

    public static int getAwkwardFourLetterPhrasesArrLength() {
        return awkwardFourLetterPhrasesArr.size();
    }

    // ....

    public static void printInvalidLetterPairsArr() {
        text.printArrayArrayList(invalidLetterPairsArr);
    }

    public static void printInvalidConsonantPairFollowingsArr() {
        text.printArrayArrayList(invalidConsonantPairFollowingsArr);
    }

    public static void printAwkwardTripletsArr() {
        text.printArrayArrayList(awkwardTripletsArr);
    }

    public static void printAwkwardFourLetterPhrasesArr() {
        text.printArrayArrayList(awkwardFourLetterPhrasesArr);
    }

    // ....

    public static ArrayList<Object[]> getAnalyzedLetterCombosArr() {
        return analyzedLetterCombosArr;
    }

    public static void analyzedLetterCombosArrAdd(String[] arr) {
        analyzedLetterCombosArr.add(arr);
    }
}
