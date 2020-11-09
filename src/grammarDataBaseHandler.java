import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class grammarDataBaseHandler {
    public static void handler(ArrayList<String> arrList) throws IOException {


        System.out.println("\n Data:");
        System.out.println("        Number of names:                        " + arrList.size());
        System.out.println("        invalidLetterPairsArr size:             " + grammarDatabase.getInvalidLetterPairsArrLength());
        System.out.println("        invalidConsonantPairFollowingsArr size: " + grammarDatabase.getInvalidConsonantPairFollowingsArrLength());
        System.out.println("        awkwardTripletsArr size:                " + grammarDatabase.getAwkwardTripletsArrLength());
        System.out.println("        awkwardFourLetterPhrasesArr size:       " + grammarDatabase.getAwkwardFourLetterPhrasesArrLength());
        text.newLine();

        Scanner scanner = new Scanner(System.in);

        int i = 0;

        boolean needToReRun = false;

        do {
            String currentNameBeingAnalyzed = arrList.get(i);
            String[] currentNameLetterList = text.stringToStringArray(currentNameBeingAnalyzed);

            // provides each two letter pair in a name
            if (!needToReRun) {
                for (int j = 0; j < currentNameLetterList.length - 1; j++) {
                    String[] currentPair = new String[2];
                    currentPair[0] = currentNameLetterList[j];
                    currentPair[1] = currentNameLetterList[j + 1];
                    ArrayList<Object[]> analyzedLetterCombosArr = grammarDatabase.getAnalyzedLetterCombosArr();
                    if (!text.contains(analyzedLetterCombosArr, currentPair)) {
                        grammarDatabase.analyzedLetterCombosArrAdd(currentPair);
                        text.newLine();
                        text.print("        Current name = " + currentNameBeingAnalyzed + "\n");
                        System.out.print("          Is the following pair valid? (y/n) : ");
                        System.out.println(currentNameLetterList[j] + currentNameLetterList[j + 1] + "  [a]");
                        System.out.print("          Answer: ");
                        String isValidAnswer = scanner.next();

                        if (isValidAnswer.toLowerCase().equals("n")) {
                            needToReRun = true;

                            System.out.print("          Can the pair be followed by a consonant? (y/n) : ");
                            String answer = scanner.next();

                            if (answer.toLowerCase().equals("y")) {
                                invalidLetterPair(currentNameLetterList[j], currentNameLetterList[j + 1]);
                                main.reRun();
                            } else if (answer.toLowerCase().equals("n")) {
                                invalidConsonantPairFollowing(currentNameLetterList[j], currentNameLetterList[j + 1]);
                                main.reRun();
                            } else {
                                throw new IllegalArgumentException("Invalid answer submitted");
                            }
                        } else if (!isValidAnswer.toLowerCase().equals("y")) {
                            throw new IllegalArgumentException("Invalid answer submitted");
                        }
                    }
                }
            }

            // provides each three letter pair in a name
            if (!needToReRun) {
                for (int j = 0; j < currentNameLetterList.length - 2; j++) {
                    String[] currentTriplet = new String[3];
                    currentTriplet[0] = currentNameLetterList[j];
                    currentTriplet[1] = currentNameLetterList[j + 1];
                    currentTriplet[2] = currentNameLetterList[j + 2];
                    ArrayList<Object[]> analyzedLetterCombosArr = grammarDatabase.getAnalyzedLetterCombosArr();
                    if (!text.contains(analyzedLetterCombosArr, currentTriplet)) {
                        grammarDatabase.analyzedLetterCombosArrAdd(currentTriplet);
                        text.newLine();
                        System.out.print("          Is the following triplet valid? (y/n) : ");
                        System.out.println(currentNameLetterList[j] + currentNameLetterList[j + 1] + currentNameLetterList[j + 2]);
                        System.out.print("          Answer: ");
                        String isValidAnswer = scanner.next();

                        if (isValidAnswer.toLowerCase().equals("n")) {
                            needToReRun = true;
                            invalidTriplet(currentNameLetterList[j], currentNameLetterList[j + 1],
                                    currentNameLetterList[j + 2]);
                            main.reRun();
                        } else if (!isValidAnswer.toLowerCase().equals("y")) {
                            throw new IllegalArgumentException("Invalid answer submitted");
                        }
                    }
                }
            }

            // provides each four letter pair in a name
            if (!needToReRun) {
                for (int j = 0; j < currentNameLetterList.length - 3; j++) {
                    String[] currentQuad = new String[4];
                    currentQuad[0] = currentNameLetterList[j];
                    currentQuad[1] = currentNameLetterList[j + 1];
                    currentQuad[2] = currentNameLetterList[j + 2];
                    currentQuad[3] = currentNameLetterList[j + 3];
                    ArrayList<Object[]> analyzedLetterCombosArr = grammarDatabase.getAnalyzedLetterCombosArr();
                    if (!text.contains(analyzedLetterCombosArr, currentQuad)) {
                        grammarDatabase.analyzedLetterCombosArrAdd(currentQuad);
                        text.newLine();
                        System.out.print("          Is the following phrase valid? (y/n) : ");
                        System.out.println(currentNameLetterList[j] + currentNameLetterList[j + 1] + currentNameLetterList[j + 2]
                                + currentNameLetterList[j + 3]);
                        System.out.print("          Answer: ");
                        String isValidAnswer = scanner.next();

                        if (isValidAnswer.toLowerCase().equals("n")) {
                            needToReRun = true;
                            invalidFourLetterPhrase(currentNameLetterList[j], currentNameLetterList[j + 1],
                                    currentNameLetterList[j + 2], currentNameLetterList[j + 3]);
                            main.reRun();
                        }
                    }
                }
            }
            i++;
        } while (!needToReRun && i < arrList.size());
    }

    private static void invalidLetterPair(String letter1, String letter2) throws IOException {
        grammarDatabase.addInvalidLetterPair(letter1, letter2);
        grammarDataBaseEditor.addInvalidLetterPair(letter1, letter2);
    }

    private static void invalidConsonantPairFollowing(String letter1, String letter2) throws IOException {
        grammarDatabase.addInvalidConsonantPairFollowing(letter1, letter2);
        grammarDataBaseEditor.addInvalidConsonantPairFollowing(letter1, letter2);
    }

    private static void invalidTriplet(String letter1, String letter2, String letter3) throws IOException {
        grammarDatabase.addAwkwardTripletsArr(letter1, letter2, letter3);
        grammarDataBaseEditor.addInvalidTriplet(letter1, letter2, letter3);
    }

    private static void invalidFourLetterPhrase(String letter1, String letter2, String letter3, String letter4) throws IOException {
        grammarDatabase.addAwkwardFourLetterPhrasesArr(letter1, letter2, letter3, letter4);
        grammarDataBaseEditor.addInvalidFourLetterPhrase(letter1, letter2, letter3, letter4);
    }
}
