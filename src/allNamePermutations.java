import java.io.IOException;
import java.util.ArrayList;

public class allNamePermutations {
    private String name1;
    private String name2;
    private Object[] name1Permutations;
    private Object[] name2Permutations;
    private ArrayList<String> combinedPermutationsArr = new ArrayList<>();

    public allNamePermutations(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;

        permutations p1 = new permutations(name1);
        permutations p2 = new permutations(name2);

        ArrayList<String> n1p = p1.getPermutations();
        ArrayList<String> n2p = p2.getPermutations();
        this.name1Permutations = n1p.toArray();
        this.name2Permutations = n2p.toArray();
    }

    public void run() throws IOException {
        this.combinePermutations(name1Permutations, name2Permutations);
        this.combinePermutations(name2Permutations, name1Permutations);
        output.run(combinedPermutationsArr);
    }

    private void combinePermutations(Object[] n1p, Object[] n2p) {
        for (int i = 0; i < n1p.length; i++) {
            for (int j = 0; j < n2p.length; j++) {
                String currentNameCombo = (n1p[i].toString().concat(n2p[j].toString())).toLowerCase();

                grammarLogic grammar = new grammarLogic(text.stringToCharArray(name1.toLowerCase()),
                        text.stringToCharArr(name2.toLowerCase()),
                        text.stringToCharacterArrList(currentNameCombo));

                if (grammar.logic()) {
                    combinedPermutationsArr.add(text.toName(currentNameCombo));
                }
            }
        }
    }

    public String[] getCombinedPermutationsArr() {
        return (String[]) combinedPermutationsArr.toArray();
    }
}
