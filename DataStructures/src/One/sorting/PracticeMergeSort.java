package One.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeMergeSort {

    public static void main(String[] args) {
        int[] arr = {52,15,8,3,-10,15,12,32};
        //List.of(arr);
        int[] finalArray = mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: {");
        Arrays.stream(finalArray).forEach(o -> System.out.print(o + " , "));
        System.out.println(" }");
    }

    private static int[] mergeSort(int[] arr, int front, int end) {
        int size = end - front + 1;
        int mid = front + size/2 - 1;
        //System.out.println(front+" F, "+end+ " end, " + mid +" Mid ");
        if (front == end) {
            int[] tempArr = new int[size];
            tempArr[0] = arr[front];
            return tempArr;
        }
        int[] first = mergeSort(arr, front , mid);
        int[] second = mergeSort(arr, mid+1 , end);
        return merge(first,second);
    }

    private static int[] merge(int[] a , int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        int loopCount = a.length + b.length;
        List<Integer> resultantArray = new ArrayList<>();
        for (int i = 0; i<loopCount; i++){
            if (listA.isEmpty()){
                resultantArray.addAll(listB);
                break;
            }else if (listB.isEmpty()) {
                resultantArray.addAll(listA);
                break;
            }
            else {
                int tempA = listA.get(0);
                int tempB = listB.get(0);
                if (tempB >= tempA) {
                    resultantArray.add(tempA);
                    listA.remove(0);
                } else
                {
                    resultantArray.add(tempB);
                    listB.remove(0);
                }
            }
        }
        return resultantArray.stream().mapToInt(i->i).toArray();
    }
}

