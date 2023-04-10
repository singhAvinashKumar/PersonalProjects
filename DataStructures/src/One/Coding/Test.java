package One.Coding;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9,10};
        int missingNum = -1;
        for (int i = 1; i<arr.length; i++){
            if (arr[i-1] != i)
            {
                missingNum = i;
                break;
            }
        }
        System.out.println(missingNum);
    }
}





