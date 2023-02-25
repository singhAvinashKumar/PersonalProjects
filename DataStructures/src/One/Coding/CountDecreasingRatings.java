package One.Coding;

//Amazon Practice section
public class CountDecreasingRatings {

    private static int countDecreasingRatings(int[] arr) {

        int count = arr.length;
        int flag = 0;
        for(int i = 1; i<arr.length; i++){
            if (arr[i-1]>arr[i]){

                flag++;
                count = count + flag;
            }else
                flag = 0;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,1};
        System.out.println("No of decreased group : "+CountDecreasingRatings.countDecreasingRatings(arr));
    }


}
