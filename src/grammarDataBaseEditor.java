import java.io.*;

public class grammarDataBaseEditor {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static void initialize() throws IOException {
        System.out.print("\n \n \n \n \n TESTING WITH .txt \n \n \n \n \n");
        reader = new BufferedReader(new FileReader("grammarRulesDataBase.txt"));
        writer = new BufferedWriter(new FileWriter("grammarRulesDataBase.txt", true));
    }


    public static void addInvalidLetterPair(String letter1, String letter2) throws IOException {
        initialize();
        String line = null;
        while ((line = reader.readLine()) != null) {
            reader.skip(1);
        }
        writer.write("Invalid letter pair: " + letter1 + letter2 + "\n");
        writer.close();
    }
    public static void addInvalidConsonantPairFollowing(String letter1, String letter2) throws IOException {
        initialize();
        String line = null;
        writer.write("Invalid consonant pair following: " + letter1 + letter2 + "\n");
        writer.newLine();
        writer.close();
    }

    public static void addInvalidTriplet(String letter1, String letter2, String letter3) throws IOException {
        initialize();
        writer.write("Invalid triplet : " + letter1 + letter2 + letter3 + "\n");
        writer.newLine();
        writer.close();
    }

    public static void addInvalidFourLetterPhrase(String letter1, String letter2, String letter3, String letter4) throws IOException {
        initialize();
        writer.write("Invalid four letter phrase : " + letter1 + letter2 + letter3 + letter4 + "\n");
        writer.newLine();
        writer.close();
    }
}
