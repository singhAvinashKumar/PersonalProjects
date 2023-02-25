package One.Coding;

public class MaxSustainableCluster {

    public static void main(String[] args) {
        int[] bootingPower = {3,6,1,3,4};
        int[] processingPower = {2,1,3,4,5};
        int maxPower = 25;
        int k = 3;
        MaxSustainableCluster.findMaxCluster(bootingPower,processingPower,maxPower,k);
    }

    private static void findMaxCluster(int[] bootingPower, int[] processingPower, int maxPower, int k) {
        int sum = 0;
        int max = 0;
        int loadFactor = 0;
        int currentLoadFactor = 0;
        for(int i = 0; i<= processingPower.length-k; i++){
            sum = 0;
            max = 0;
            for (int j = i; j< i+k; j++) {
                sum = sum + processingPower[j];
                if (bootingPower[j] > max)
                    max = bootingPower[j];
            }
            //System.out.println("Sum : "+sum+" k ; "+k +" Max : " + max);
             currentLoadFactor = sum*k + max;
            if (loadFactor == maxPower)
                break;
            else if (currentLoadFactor < maxPower && currentLoadFactor > loadFactor)
                    loadFactor = currentLoadFactor;
        }
        System.out.println("load Factor : " + loadFactor);
    }
}
