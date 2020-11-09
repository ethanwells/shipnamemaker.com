import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;

public class text {

    public static void print(Object str) {
        System.out.print(str);
    }

    public static void newLine() {
        System.out.println("");
    }

    public static String toName(ArrayList<Character> arrList) {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < arrList.size(); i++) {
            strBuilder.append(arrList.get(i));
        }
        String finalString = strBuilder.toString();
        return firstUpperAllLower(finalString);
    }

    public static String toName(char[] arr) {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            strBuilder.append(arr[i]);
        }
        String finalString = strBuilder.toString();
        return firstUpperAllLower(finalString);
    }

    public static String toName(String[] arr) {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            strBuilder.append(arr[i]);
        }
        String finalString = strBuilder.toString();
        return firstUpperAllLower(finalString);
    }

    public static String toName(String string) {
        return firstUpperAllLower(string);
    }


    public static String toString(Character character) {
        StringBuilder strBuilder = new StringBuilder("");
        strBuilder.append(character);
        return strBuilder.toString();
    }

    public static String toString(char character) {
        StringBuilder strBuilder = new StringBuilder("");
        strBuilder.append(character);
        return strBuilder.toString();
    }

    public static String toString(ArrayList<Character> arrList) {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < arrList.size(); i++) {
            strBuilder.append(arrList.get(i));
        }
        return strBuilder.toString();
    }

    public static String toString(Object letterObject) {
        StringBuilder strBuilder = new StringBuilder("");
        strBuilder.append(letterObject);
        return strBuilder.toString();
    }

    public static Character stringToCharacter(String string) {
        Character character = string.charAt(0);
        return character;
    }

    public static char[] stringToCharArray(String name) {
        char[] nameCharArray = new char[name.length()];

        for (int i = 0; i < name.length(); i++) {
            nameCharArray[i] = name.charAt(i);
        }
        return nameCharArray;
    }

    public static String[] stringToStringArray(String name) {
        String[] nameLetterArray = new String[name.length()];

        for (int i = 0; i < name.length(); i++) {
            String currentLetter = toString(name.charAt(i));
            nameLetterArray[i] = currentLetter;
        }
        return nameLetterArray;
    }


    public static String firstUpperAllLower(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;
    }

    public static boolean isConsonant(Character character) {
        return !isVowel(character);
    }

    public static boolean isConsonant(String letter) {
        return !isVowel(letter);
    }

    public static boolean isVowel(Character character) {
        return isVowel(character.toString());
    }

    public static boolean isVowel(String character) {

        character = character.toLowerCase();

        if (!character.equals("a") && !character.equals("e") && !character.equals("i")
                && !character.equals("o") && !character.equals("u") && !character.equals("y")) {
            return false;
        }
        return true;
    }

    public static String removeCharInStringAtIndex(String string, int index) {
        char[] stringCharArray = stringToCharArray(string);
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < string.length(); i++) {
            if (i != index) {
                stringBuilder.append(stringCharArray[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static char[] stringToCharArr(String string) {
        char[] charArray = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            charArray[i] = string.charAt(i);
        }
        return charArray;
    }

    public static ArrayList<Character> stringToCharacterArrList(String string) {
        ArrayList<Character> characterArrList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            characterArrList.add((Character) string.charAt(i));
        }
        return characterArrList;
    }

    public static void printArrayList(ArrayList<String> arr) {
        text.newLine();
        text.newLine();
        text.newLine();
        System.out.println("            Array:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("                " + arr.get(i));
        }
        text.newLine();
        text.newLine();
        text.newLine();
    }

    public static void printArrayArrayList(ArrayList<String[]> arr) {
        text.newLine();
        text.newLine();
        text.newLine();
        System.out.println("            Array:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("                ");
            for (int j = 0; j < arr.get(i).length; j++) {
                System.out.print(arr.get(i)[j]);
            }
        }
        text.newLine();
        text.newLine();
        text.newLine();
    }

    public static void printArray(Object[] arr) {
        text.newLine();
        text.newLine();
        text.newLine();
        System.out.println("            Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("                " + arr[i]);
        }
        text.newLine();
        text.newLine();
        text.newLine();
    }

    public static void printArray(char[] arr) {
        text.newLine();
        text.newLine();
        text.newLine();
        System.out.println("            Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("                " + arr[i]);
        }
        text.newLine();
        text.newLine();
        text.newLine();
    }

    public static ArrayList<String> arrListToAlphabeticalOrder(ArrayList<String> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                if (arrList.get(i).compareTo(arrList.get(j)) > 0) {
                    String temp = arrList.get(i);
                    arrList.set(i, arrList.get(j));
                    arrList.set(j, temp);
                }
            }
        }
        return arrList;
    }

    public static ArrayList<String> arrListToDecreasingLengthOrder(ArrayList<String> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = i + 1; j < arrList.size(); j++) {
                if (arrList.get(i).length() < arrList.get(j).length()) {
                    String temp = arrList.get(i);
                    arrList.set(i, arrList.get(j));
                    arrList.set(j, temp);
                }
            }
        }
        return arrList;
    }

    public static boolean contains(ArrayList<Object[]> arrListArr, String[] stringArr) {
        for (Object[] item : arrListArr) {
            if (item.length == stringArr.length) {
                for (int i = 0; i < item.length; i++) {
                    String currentLetter = text.toString(item[i]);
                    if (currentLetter.equals(stringArr[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
