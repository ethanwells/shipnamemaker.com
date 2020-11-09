import java.util.ArrayList;

public class grammarLogic {

    private char[] name1Arr;
    private char[] name2Arr;
    private ArrayList<Character> currentNameCharCombo;

    public grammarLogic(char[] name1Arr, char[] name2Arr, ArrayList<Character> currentNameCharCombo) {
        this.name1Arr = name1Arr;
        this.name2Arr = name2Arr;
        this.currentNameCharCombo = currentNameCharCombo;
    }

    public boolean logic() {
        return firstCharacterIsFirstCharacter()
                && lastCharacterIsLastCharacter()
                && notEntireBothNames()
                && notAllConsonants()
                && notAllVowels()
                && noDoubleLetterEndings()
                && uFollowsQ()
                && vowelsSandwichConsonantPairs()
                && iBeforeEExceptAfterC()
                // && noAwkwardTriplets()
                && noInvalidVowelTriplets()
                && noConsecutiveFourVowels()
                && longerThanThreeLetter()
                && noAwkwardFourLetterPhrases()
                && noAwkwardInteriorPairs();
    }

    private boolean firstCharacterIsFirstCharacter() {

        Character name1FirstCharacter = new Character(name1Arr[0]);
        Character name2FirstCharacter = new Character(name2Arr[0]);
        Character lastCharacter = currentNameCharCombo.get(0);

        return lastCharacter.equals(name1FirstCharacter) || lastCharacter.equals(name2FirstCharacter)
                && notEntireBothNames();
    }

    private boolean lastCharacterIsLastCharacter() {

        Character name1LastCharacter = new Character(name1Arr[name1Arr.length - 1]);
        Character name2LastCharacter = new Character(name2Arr[name2Arr.length - 1]);
        Character lastCharacter = currentNameCharCombo.get(currentNameCharCombo.size() - 1);

        return lastCharacter.equals(name1LastCharacter) || lastCharacter.equals(name2LastCharacter)
                && notEntireBothNames();
    }

    private boolean notEntireBothNames() {
        String name1 = text.toName(name1Arr).toLowerCase();
        String name2 = text.toName(name2Arr).toLowerCase();
        String name1AndName2 = name1.concat(name2);
        String name2AndName1 = name2.concat(name1);

        if (text.toName(currentNameCharCombo).toLowerCase().equals(name1AndName2) || text.toName(currentNameCharCombo).toLowerCase().equals(name2AndName1)) {
            return false;
        }
        return true;
    }

    private boolean notAllConsonants() {
        for (int i = 0; i < currentNameCharCombo.size(); i++) {
            if (text.isVowel(currentNameCharCombo.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean notAllVowels() {
        for (int i = 0; i < currentNameCharCombo.size(); i++) {
            if (text.isConsonant(currentNameCharCombo.get(i))) {
                return true;
            }
        }
        return false;
    }

    // no double letters at end besides 'ee' and 'oo'
    private boolean noDoubleLetterEndings() {
        String secondToLastLetter = text.toString(currentNameCharCombo.get(currentNameCharCombo.size() - 1)).toLowerCase();
        String lastLetter = text.toString(currentNameCharCombo.get(currentNameCharCombo.size() - 2)).toLowerCase();
        if (text.isVowel(secondToLastLetter) && text.isVowel(lastLetter) || secondToLastLetter.equals(lastLetter)) {
            if (secondToLastLetter.equals("e") && lastLetter.equals("e")) {
                return true;
            } else if (secondToLastLetter.equals("o") && lastLetter.equals("o")) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    private boolean uFollowsQ() {
        for (int i = 0; i < currentNameCharCombo.size() - 1; i++) {
            String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
            String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();

            if (currentLetter.equals("q") && !nextLetter.equals("u")) {
                return false;
            } else if (i == currentNameCharCombo.size() - 2 && nextLetter.equals("q")) {
                return false;
            }
        }
        return true;
    }

    private boolean vowelsSandwichConsonantPairs() {
        if (currentNameCharCombo.size() > 3) {
            for (int i = 0; i < currentNameCharCombo.size() - 3; i++) {

                String firstOuter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
                String firstInner = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
                String secondInner = text.toString(currentNameCharCombo.get(i + 2)).toLowerCase();
                String secondOuter = text.toString(currentNameCharCombo.get(i + 3)).toLowerCase();

                // if 'h' is second letter in name, first letter must be 's', 't', 'w', 'p', or 'c'
                if (i == 0 && text.isConsonant(firstOuter) && text.isConsonant(firstInner)) {
                    String firstLetter = firstOuter;
                    String secondLetter = firstInner;
                    if (secondLetter.equals("h")) {
                        if (!firstLetter.equals("s") && !firstLetter.equals("t")
                                && !firstLetter.equals("w") && !firstLetter.equals("p") && !firstLetter.equals("c")) {
                            return false;
                        }
                    } else if (firstLetter.equals("s")) {
                        if (secondLetter.equals("d") || secondLetter.equals("g") || secondLetter.equals("z") ||
                                secondLetter.equals("x") || secondLetter.equals("b")) {
                            return false;
                        }
                    } else if (firstLetter.equals("t")) {
                        if (!secondLetter.equals("h")) {
                            return false;
                        }
                    } else if (firstLetter.equals("t")) {
                        if (!secondLetter.equals("h")) {
                            return false;
                        }
                    }
                    return false;
                }
                // if two last letters are consonants
                if (i == currentNameCharCombo.size() - 4) {
                    String secondToLastLetter = secondInner;
                    String lastLetter = secondOuter;
                    if (text.isConsonant(secondToLastLetter) && text.isConsonant(lastLetter)) {
                        if (lastLetter.equals("h")) {
                            if (!secondToLastLetter.equals("s") && !secondToLastLetter.equals("t") &&
                                    !secondToLastLetter.equals("w") && !secondToLastLetter.equals("p") &&
                                    !secondToLastLetter.equals("c")) {
                                return false;
                            }
                        } else if (!secondToLastLetter.equals("r") && !secondToLastLetter.equals("l")) {
                            return false;
                        }
                    }
                }
                if (text.isConsonant(firstInner) && text.isConsonant(secondInner)) {
                    if (!text.isVowel(firstOuter) || !text.isVowel(secondOuter)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean iBeforeEExceptAfterC() {
        for (int i = 0; i < currentNameCharCombo.size() - 1; i++) {
            String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
            String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
            if (currentLetter.equals("e") && nextLetter.equals("i")) {
                for (int j = i; j > 0; j--) {
                    String probeLetter = text.toString(currentNameCharCombo.get(j)).toLowerCase();
                    if (probeLetter.equals("c")) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /*
    private boolean noAwkwardTriplets() {
        if (runType.getRunType().equals("see")) {
            return awkwardTripletsComputer("e", "o", "i")
                    && awkwardTripletsComputer("a", "e", "h")
                    && awkwardTripletsComputer("e", "h", "a")
                    && awkwardTripletsComputer("a", "h", "a")
                    && awkwardTripletsComputer("i", "y", "n")
                    && awkwardTripletsComputer("d", "h", "a")
                    && awkwardTripletsComputer("d", "h", "y")
                    && awkwardTripletsComputer("d", "h", "n")
                    && awkwardTripletsComputer("v", "y", "a");
        } else if (runType.getRunType().equals("edit")) {
            if (grammarDatabase.getAwkwardTripletsArrLength() > 0) {
                for (String[] triplet : grammarDatabase.getAwkwardTripletsArr()) {
                    if (!awkwardTripletsComputer(triplet[0], triplet[1], triplet[2])) {
                        return false;
                    }
                }
            }
            return  true;
        } else {
            throw new IllegalArgumentException("Invalid run type entered.");
        }
    }

    private boolean awkwardTripletsComputer(String letter1, String letter2, String letter3) {
        for (int i = 0; i < currentNameCharCombo.size() - 2; i++) {
            String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
            String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
            String nextNextLetter = text.toString(currentNameCharCombo.get(i + 1 + 1)).toLowerCase();

            if (currentLetter.equals(letter1.toLowerCase()) && nextLetter.equals(letter2.toLowerCase())
                    && nextNextLetter.equals(letter3.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
     */

    private boolean noInvalidVowelTriplets() {
        for (int i = 0; i < currentNameCharCombo.size() - 2; i++) {
            String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
            String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
            String nextNextLetter = text.toString(currentNameCharCombo.get(i + 2)).toLowerCase();

            if (text.isVowel(currentLetter) && text.isVowel(nextLetter) && text.isVowel(nextNextLetter)) {
                if (!currentLetter.equals(nextLetter) && !currentLetter.equals(nextNextLetter) &&
                        !nextLetter.equals(nextNextLetter)) {
                    return false;
                }
            }

            if (text.isVowel(currentLetter) && text.isVowel(nextLetter) && text.isVowel(nextNextLetter)) {
                if (currentLetter.equals(nextLetter) && nextLetter.equals(nextNextLetter)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean noConsecutiveFourVowels() {
        if (currentNameCharCombo.size() >= 4) {
            for (int i = 0; i < currentNameCharCombo.size() - 3; i++) {
                String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
                String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
                String nextNextLetter = text.toString(currentNameCharCombo.get(i + 1 + 1)).toLowerCase();
                String nextNextNextLetter = text.toString(currentNameCharCombo.get(i + 1 + 1 + 1)).toLowerCase();

                if (text.isVowel(currentLetter) && text.isVowel(nextLetter) && text.isVowel(nextNextLetter) &&
                        text.isVowel(nextNextNextLetter)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean longerThanThreeLetter() {
        return currentNameCharCombo.size() > 3;
    }

    private boolean noAwkwardFourLetterPhrases() {
        if (runType.getRunType().equals("see")) {
            return awkwardFourLetterPhrasesComputer("i", "a", "h", "a")
                    && awkwardFourLetterPhrasesComputer("n", "i", "a", "h")
                    && awkwardFourLetterPhrasesComputer("e", "e", "h", "n")
                    && awkwardFourLetterPhrasesComputer("o", "i", "h", "n")
                    && awkwardFourLetterPhrasesComputer("c", "e", "h", "n")
                    && awkwardFourLetterPhrasesComputer("n", "e", "h", "n");
        } else if (runType.getRunType().equals("edit")) {
            if (grammarDatabase.getAwkwardFourLetterPhrasesArrLength() > 0) {
                for (String[] phrase : grammarDatabase.getAwkwardFourLetterPhrasesArr()) {
                    if (!awkwardFourLetterPhrasesComputer(phrase[0], phrase[1], phrase[2], phrase[3])) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Invalid run type entered.");
        }
    }

    private boolean awkwardFourLetterPhrasesComputer(String letter1, String letter2, String letter3, String letter4) {
        if (currentNameCharCombo.size() >= 4) {
            for (int i = 0; i < currentNameCharCombo.size() - 3; i++) {
                String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
                String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();
                String nextNextLetter = text.toString(currentNameCharCombo.get(i + 1 + 1)).toLowerCase();
                String nextNextNextLetter = text.toString(currentNameCharCombo.get(i + 1 + 1 + 1)).toLowerCase();

                if (currentLetter.equals(letter1.toLowerCase()) && nextLetter.equals(letter2.toLowerCase())
                        && nextNextLetter.equals(letter3.toLowerCase()) &&
                        nextNextNextLetter.equals(letter4.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean noAwkwardInteriorPairs() {
        return awkwardInteriorPairsComputer("a", "a")
            && awkwardInteriorPairsComputer("i", "i")
            && awkwardInteriorPairsComputer("u", "u")
            && awkwardInteriorPairsComputer("y", "y");

    }

    private boolean awkwardInteriorPairsComputer(String letter1, String letter2) {
        for (int i = 1; i < currentNameCharCombo.size() - 2; i++) {
            String currentLetter = text.toString(currentNameCharCombo.get(i)).toLowerCase();
            String nextLetter = text.toString(currentNameCharCombo.get(i + 1)).toLowerCase();

            if (currentLetter.equals(letter1) && nextLetter.equals(letter2)) {
                return false;
            }
        }
        return true;
    }
}
