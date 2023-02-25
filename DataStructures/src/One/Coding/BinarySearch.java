package One.Coding;

public class BinarySearch {

    int binarysearch(int arr[], int n, int k) {
        if(arr.length == 0)
            return 0;
        return searchBinary(arr,0,n-1,k);
    }

    int searchBinary(int arr[], int start, int end , int k){

        if((end-start)+1 <= 1)
            return -1;

        int mid = (end-start)+1/2;
        int midElem = arr[mid];
        if( k < midElem )
            return  searchBinary(arr,start,mid-1,k);
        else if(k > midElem)
            return searchBinary(arr,midElem+1,end,k);
        else
            return mid;


    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,8,9,10,11,12,13,14,16,17,19,22,23,24,26,28,31,33,34,36,37,38,39,40,42,43,44,46,47,48,49,50,54,55,59,60,62,63,64,65,66,68,69,70,71,72,73,75,77,79,80,82,86,87,88,92,93,94,96,97,98,99,100};
        int n = arr.length;
        BinarySearch bs = new BinarySearch();
        int index = bs.binarysearch(arr,n,15);
        System.out.println("K is present at Index : "+ index);

    }
}
