package Coding;

import java.util.Arrays;

public class BinarySearch2 {

    int[] result = new int[2];
    int[] nums2;
    int target;

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,10};
        int k = 8;
        BinarySearch2 bs2 = new BinarySearch2();
        int[] arr2 = bs2.searchRange(arr,k);
        Arrays.stream(arr2).forEach(System.out::println);
    }

    public int[] searchRange(int[] nums, int target) {
            nums2 = nums;
            this.target = target;
            int pos = locateTarget(0,nums.length-1);
            if(pos == -1)
            {
                result[0]=-1;
                result[1]=-1;
                return result;
            }
            int posNeg=pos;
            int posPostive = pos;
            while(nums[posNeg]==target){
                result[0]=posNeg;
                posNeg--;
            }
            while(nums[posPostive]==target){
                result[1]=posPostive;
                posPostive++;
            }
            return result;
        }

        public int locateTarget(int start, int end){
            int size = (end-start)+1;
            int pos = -1;
            if(size == 1)
                pos = (nums2[start]==this.target)?start:-1;
            int mid = start + size/2;
            System.out.println("At loc : "+mid+", Value : "+nums2[mid]+", Target :"+this.target);
            if(this.target> nums2[mid])
                locateTarget(mid+1,end);
            else if(this.target < nums2[mid])
                locateTarget(start,mid-1);
            else if(this.target == nums2[mid])
            {
                System.out.println("Inside equals:");
                pos = mid;
                return pos;
            }
            return pos;
        }
}
