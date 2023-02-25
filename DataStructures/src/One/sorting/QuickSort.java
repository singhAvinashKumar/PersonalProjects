package One.sorting;

public class QuickSort {

    public static void sort(int[] arr,int p,int r){
        if (p>=r)
            return;
        int q = partition(arr, p, r);
        if (q == r)
            q--;
        sort(arr,p,q);
        sort(arr,q+1,r);

        
    }
    public static int partition (int[] arr,int p,int r){

        if (p==r)
            return p;
        //System.out.println("Start :" +p+", End : "+r);
        int i = p;
        int j = r;
        int pivot = arr[j];
        while (true){
            while (i<arr.length && arr[i]<=pivot ){
          //      System.out.print("Value at Index "+i+" is : "+arr[i]+ ", ");
                i++;
                //System.out.print(i+" P "+arr[i]+ ", ");
            }
            //System.out.println();
            while (j>=0 && arr[j]>pivot ){
            //    System.out.print("Value at Index "+j+" is :"+arr[j]+", ");
                j--;
                //System.out.print(arr[j]+" r :"+j+", ");
            }
            //System.out.println();
            if (i<j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else
                return j;
        }
    }

    public static void main(String[] args) {
        int[] arr ={42,25,82,13,41,04,34,22,15,27};
        QuickSort.sort(arr,0,arr.length-1);

        for (int e: arr) {
            System.out.print(e+", ");
        }
        /*{27,25,22,13,(05),41,34,82,55,42}
        {(05),25,22,13,27,41,34,42,(55),82}
        {(05),25,22,13,27,41,34,82,55,42}*/
    }
}
