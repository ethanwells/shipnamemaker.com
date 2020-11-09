import java.io.IOException;
import java.util.ArrayList;

public class output {
    public static void run(ArrayList<String> arrList) throws IOException {

        if (runType.getRunType().equals("see")) {
            System.out.println("number of names: " + arrList.size());

            arrList = ensureNoDuplicateNames.removeDuplicates(arrList);
            //arrList = text.arrListToAlphabeticalOrder(arrList);
            arrList = text.arrListToDecreasingLengthOrder(arrList);


            for (int i = 0; i < arrList.size(); i++) {
                System.out.println(arrList.get(i));
            }
        } else {
            arrList = ensureNoDuplicateNames.removeDuplicates(arrList);
            arrList = text.arrListToDecreasingLengthOrder(arrList);
            grammarDataBaseHandler.handler(arrList);
        }
    }
}
