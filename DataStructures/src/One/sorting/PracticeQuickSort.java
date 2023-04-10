package One.sorting;

import java.util.Arrays;

public class PracticeQuickSort {
    public static void main(String[] args) {
        int[] arr = {52,15,8,3,0,15,12,110};
        //List.of(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: {");
        Arrays.stream(arr).forEach(o -> System.out.print(o + " , "));
        System.out.println(" }");
    }

    private static void quickSort(int[] arr, int front, int end) {
        if (front == end)
            return;
        int pos = sort(arr, front, end);
        if (pos == end)
            pos--;
        quickSort(arr,front,pos);
        quickSort(arr,pos+1,end);

    }

    private static int sort(int[] arr, int front, int end) {
        int pivot = arr[end];
    //    System.out.println("--------------------New Stack Call-------------------");
    //    System.out.println(" : --> " + "Front: " + front + ", End: " + end);

        while (true){
            while (arr[end] > pivot && end>0 ){
                end--;
            }
            while (front<=arr.length-1 && arr[front] <= pivot ){
                front++;
            }
    /*        System.out.println("Front: "+ front + ", End: "+ end);
            System.out.println("Sorted Array: {");
            Arrays.stream(arr).forEach(o -> System.out.print(o + " , "));
            System.out.println(" }");
    */        if (end > front) {
      //          System.out.println("Swapping : --> " + "Front: " + arr[front] + ", End: " + arr[end]);
                swap(arr, front, end);
                front++;
                end--;
            } else {
                break;
            }
        }
        return end;
    }

    private static void swap(int[] arr, int front, int end) {
        int temp = arr[front];
        arr[front] = arr[end];
        arr[end] = temp;
    }
}
