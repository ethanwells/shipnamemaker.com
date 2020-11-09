import java.io.IOException;
import java.util.Scanner;

public class runType {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean continueComputing = true;
    private static String name1;
    private static String name2;
    private static String runType;
    private static String computeType;

    public static void initialize() throws IOException {
        determineNames();
        determineComputeType();
        determineRunType();
        run();
        continueComputing();
    }

    private static void determineNames() {
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
        System.out.print("Enter name #1: ");
        String firstName = scanner.next().toLowerCase();
        text.newLine();
        name1 = firstName;

        System.out.print("Enter name #2: ");
        String secondName = scanner.next().toLowerCase();
        text.newLine();
        name2 = secondName;
    }

    private static void determineComputeType() {
        System.out.println("Would you like to: ");
        System.out.println("    A: Compute traditional ship names");
        System.out.println("    B: Compute all possible ship names");
        text.newLine();
        text.print("Answer: ");
        String chosenComputeType = scanner.next().toLowerCase();
        text.newLine();
        text.newLine();

        if (chosenComputeType.equals("a")) {
            computeType = "traditional";
        } else if (chosenComputeType.equals("b")) {
            computeType = "allPermutations";
        } else {
            throw new IllegalArgumentException("\n \nInvalid compute type entered. You can type 'A' or 'B'. "
                    + "\nHowever, you typed: " + computeType);
        }
    }

    private static void determineRunType() {
        System.out.println("Would you like to: ");
        System.out.println("    A: See ship names");
        System.out.println("    B: Edit ship name grammar rule");
        text.newLine();
        text.print("Answer: ");
        String seeOrEditNames = scanner.next().toLowerCase();
        text.newLine();
        text.newLine();

        if (seeOrEditNames.equals("a")) {
            runType = "see";
        } else if (seeOrEditNames.equals("b")) {
            runType = "edit";
        } else {
            throw new IllegalArgumentException("\n \nInvalid run type entered. You can type 'A' or 'B'. "
                    + "\nHowever, you typed: " + seeOrEditNames);
        }
    }

    private static void continueComputing() throws IOException {
        while (continueComputing) {
            text.newLine();
            text.newLine();
            System.out.println("Would you like to re-compute?: ");
            System.out.println("    A: Yes, re-compute with the same-names, but show " + getOppositeComputeTypePhrase()
                    + ".");
            System.out.println("    B: Yes, but re-compute " + getComputeTypePhrase() + " with different names.");
            System.out.println("    C: Yes, but re-compute " + getOppositeComputeTypePhrase() + " with different names.");
            System.out.println("    D: No, terminate program.");
            text.newLine();
            text.print("Answer: ");
            String continueAnswer = scanner.next().toLowerCase();
            text.newLine();
            text.newLine();


            if (continueAnswer.equals("a")) {
                computeType = getOppositeComputeType();
                run();
            } else if (continueAnswer.equals("b")) {
                determineNames();
                run();
            } else if (continueAnswer.equals("c")) {
                determineNames();
                computeType = getOppositeComputeType();
                run();
            } else if (continueAnswer.equals("d")) {
                text.newLine();
                text.newLine();
                text.newLine();
                text.print("    *** Program Terminated ***");
                text.newLine();
                text.newLine();
                text.newLine();
                continueComputing = false;
            } else {
                throw new IllegalArgumentException("\n \nInvalid response entered. You can type 'A', 'B', 'C', or 'D'. "
                        + "\nHowever, you typed: " + continueAnswer);
            }
        }
    }

    private static void run() throws IOException {

        shipNamesCalculator shipNames = new shipNamesCalculator(name1, name2, computeType);
        shipNames.run();
    }

    private static String getOppositeComputeTypePhrase() {
        return computeType.equals("traditional") ? "all possible ship-names" :
                "traditional ship-names";
    }

    private static String getComputeTypePhrase() {
       return computeType.equals("traditional") ? "traditional ship names" :
                "all possible ship names";
    }


    public static String getName1() {
        return name1;
    }
    public static String getName2() {
        return name2;
    }
    public static String getComputeType() {
        return computeType;
    }
    public static String getOppositeComputeType() {
        return computeType.equals("traditional") ? "allPermutations" :
                "traditional";
    }
    public static String getRunType() {
        return runType;
    }
}
