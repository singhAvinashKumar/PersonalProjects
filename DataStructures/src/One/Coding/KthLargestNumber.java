package One.Coding;

import java.util.HashMap;
import java.util.Map;

public class KthLargestNumber {

    public static void main(String[] args) {
        int[] arr = {2,6,3,66,43,23};
        int k = 3;
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        Map<Integer,Integer> diff = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            
        }
    }
}
