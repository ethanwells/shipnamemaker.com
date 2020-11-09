import java.io.IOException;
import java.util.ArrayList;

public class traditionalNameCombinations {

    private static int iteration = 0;
    private ArrayList<String> shipNamesArr = new ArrayList<>();

    public void compute(char[] name1Arr, char[] name2Arr) throws IOException {
        computeForwards(name1Arr, name2Arr);
        computeForwards(name2Arr, name1Arr);

        computeBackwards(name1Arr, name2Arr);
        computeBackwards(name2Arr, name1Arr);

        output.run(shipNamesArr);
    }

    public void computeForwards(char[] name1Arr, char[] name2Arr) {
        ArrayList<Character> currentNameCharCombo;

        //note: i = columns [this][], j = rows [][this]
        for (int i = 0; i < name1Arr.length; i++) {
            currentNameCharCombo = new ArrayList<>();
            //add first letters of longer name
            for (int k = 0; k <= i; k++) {
                currentNameCharCombo.add(name1Arr[k]);
            }
            //add letters of shorter name
            for (int j = 0; j < name2Arr.length; j++) {
                currentNameCharCombo.add(name2Arr[j]);

                Character name1LastCharacter = new Character(name1Arr[name1Arr.length - 1]);
                Character name2LastCharacter = new Character(name2Arr[name2Arr.length - 1]);
                Character lastCharacter = currentNameCharCombo.get(currentNameCharCombo.size() - 1);

                grammarLogic grammar = new grammarLogic(name1Arr, name2Arr, currentNameCharCombo);
                if (grammar.logic()) {
                    shipNamesArr.add(text.toName(text.toString(currentNameCharCombo)));
                }
            }
        }
    }

    public void computeBackwards(char[] name1Arr, char[] name2Arr) {
        ArrayList<Character> currentNameCharCombo;

        //note: i = columns [this][], j = rows [][this]
        for (int i = 0; i < name1Arr.length; i++) {
            currentNameCharCombo = new ArrayList<>();
            //add first letters of longer name
            for (int k = 0; k <= i; k++) {
                currentNameCharCombo.add(name1Arr[k]);
            }
            //add letters of shorter name
            for (int j = name2Arr.length - 1; j >= 0; j--) {
                currentNameCharCombo = shiftLastAddBefore(currentNameCharCombo, name2Arr[j]);

                grammarLogic grammar = new grammarLogic(name1Arr, name2Arr, currentNameCharCombo);
                if (grammar.logic()) {
                    shipNamesArr.add(text.toName(text.toString(currentNameCharCombo)));
                }
            }
            iteration = 0;
        }
    }

    public ArrayList<Character> shiftLastAddBefore(ArrayList<Character> currentNameCharCombo, Character newCharacter) {
        ArrayList<Character> list = currentNameCharCombo;
        if (iteration == 0) {
            list.add(newCharacter);
            iteration++;
            return list;
        } else {
            Character tempChar;
            Character tempLast = list.get(list.size() - 1);
            int insertIndex = list.size() - iteration;
            int lastIndex = list.size() - 1;

            list.add(tempLast);
            // shift elements down
            for (int i = lastIndex; i >= insertIndex; i--) {
                list.set(i, list.get(i - 1));
            }

            // delete index to insert
            list.set(insertIndex, newCharacter);
            iteration++;
            return list;
        }
    }
}
