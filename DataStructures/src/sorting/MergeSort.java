package sorting;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    public void sort(List<Integer> iList, Comparator<Integer> comparator){
        int size = iList.size();
        // Base case
        if (size < 2)
            return;
        int mid = size/2;
        List<Integer> iList1 = new ArrayList<>();
        List<Integer> iList2 = new ArrayList<>();

        for (int i = 0; i< mid ; i++){
            iList1.add(iList.get(i));
        }
        for (int i = mid; i< iList.size(); i++)
            iList2.add(iList.get(i));

        //Recursively call both sequence
        sort(iList1,comparator);
        sort(iList2,comparator);
        merge(iList1,iList2,comparator,iList);
        //iList.forEach(System.out::print);
        //System.out.println();

    }

    private void merge(List<Integer> iList1, List<Integer> iList2, Comparator<Integer> comparator, List<Integer> iList) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (!iList1.isEmpty() && !iList2.isEmpty()){
            if (comparator.compare(iList1.get(i),iList2.get(j)) < 0){
                System.out.println("List 1 -> "+iList1.get(i)+ " List 2 -> "+ iList2.get(j));
                System.out.println("i = "+i + " j = "+j );
                System.out.println("size 1 :"+ iList1.size() + " Size 2 :"+ iList2.size());
                iList.add(k,iList1.get(i));
                iList1.remove(i);
                System.out.println("size 1 :"+ iList1.size() + " Size 2 :"+ iList2.size());
                iList.forEach(System.out::print);
                System.out.println("Above ilist");
                i++;
                k++;
            }else {
                System.out.println("List 1 -> "+iList1.get(i)+ " List 2 -> "+ iList2.get(j));
                System.out.println("i = "+i + " j = "+j );
                System.out.println("size 1 :"+ iList1.size() + " Size 2 :"+ iList2.size());

                iList.add(k,iList2.get(j));
                iList2.remove(j);
                j++;
                k++;
            }
        }
        if (!iList1.isEmpty()){
            while (!iList1.isEmpty()){
                iList.add(k,iList1.get(i));
                iList1.remove(i);
                i++;
                k++;
            }
        }
        if (!iList2.isEmpty()){
            while (!iList2.isEmpty()){
                iList.add(k,iList2.get(j));
                iList2.remove(j);
                i++;
                k++;
            }
        }
        iList.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(15);
        integerList.add(7);
        integerList.add(2);
        integerList.add(25);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(integerList,(o1, o2) -> o1-o2 );
    }
}
