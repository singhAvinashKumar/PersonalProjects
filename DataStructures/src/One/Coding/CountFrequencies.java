package One.Coding;

import java.util.HashMap;

public class CountFrequencies {
    private static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = {3,5,6,5,3,3,5,5,2,2,7,7,3};
        int m = 4;
        System.out.println("Required frequency is : "+CountFrequencies.count(arr,m));

    }

    private static int count(int[] arr,int m) {
        int countFrequencies = 0;
        for (int e : arr){

            if (map.containsKey(e))
             {
                 Integer value = map.get(e);
                 //System.out.println(e + " " + value);
                 map.put(e,++value);
            }
            map.putIfAbsent(e,1);
        }
        for (int elem : map.values()){
           // System.out.println( elem);
            if (elem >= m)
                continue;
            countFrequencies = countFrequencies + (m - elem);
        }
        return countFrequencies;
    }
}
