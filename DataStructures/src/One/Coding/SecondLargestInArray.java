package One.Coding;

public class SecondLargestInArray {
    public static void main(String[] args) {

        int[] arr = {2,4,3,7,45,48,42,6,46};
        int largest = arr[0];
        int secondLargest = largest;
        for (int i = 0; i<arr.length; i++){
            if (largest < arr[i]) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (secondLargest <= arr[i]) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest: " + largest +", 2nd Largest : "+secondLargest);
    }
}
