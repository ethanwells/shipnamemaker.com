import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ensureNoDuplicateNames {
    private static ArrayList<String> finalArrList = new ArrayList<String>();

    public static ArrayList<String> removeDuplicates(ArrayList<String> arrList) {
        finalArrList = new ArrayList<String>();
        Set set = new HashSet<>(5000);
        for (int i = 0; i < arrList.size(); i++) {
            set.add(arrList.get(i));
        }

        Object[] setArr = set.toArray();

        for (int i = 0; i < setArr.length; i++) {
            if (setArr[i] != null) {
                finalArrList.add(setArr[i].toString());
            }
        }
        return finalArrList;
    }
}
