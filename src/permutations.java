import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class permutations {
    private int iterations;
    private Set permutationSet;
    private String name;
    private char[] nameCharArr;
    private ArrayList<String> permutationsArr;

    public permutations(String name) {
        this.iterations = 0;
        this.name = name;
        this.permutationSet = new HashSet<>(100);
        this.nameCharArr = text.stringToCharArray(name);
        this.start();
    }

    public void start() {
        permutationsAlgo(name);
    }

    private void permutationsAlgo(String name) {
        permutationSet.add(name);
        for (int i = 0; i < name.length(); i++) {
            String newName = text.removeCharInStringAtIndex(name, i);
            permutationSet.add(newName);
            permutationsAlgo(newName);
            iterations++;
        }
    }

    public ArrayList<String> getPermutations() {
        Object[] calculatedPermutationsArr = permutationSet.toArray();
        permutationsArr = new ArrayList<>();
        for (int i = 0; i < permutationSet.size(); i++) {
            if (!calculatedPermutationsArr[i].equals("") && !calculatedPermutationsArr[i].equals(null)) {
                permutationsArr.add(calculatedPermutationsArr[i].toString());
            }
        }
        return permutationsArr;
    }

    public int getIterations() {
        return this.iterations;
    }
}
