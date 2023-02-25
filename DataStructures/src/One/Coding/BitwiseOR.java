package One.Coding;

public class BitwiseOR {
    public static void main(String[] args) {
        String[] arr = {"00011","01010"};
        String result = "";
        int result2 = Integer.parseInt(arr[0]) | Integer.parseInt(arr[1]);
        String currentBit = "";
        for (int i = 0; i<arr[0].length(); i++){

            int val1 = Character.getNumericValue(arr[0].charAt(i));
            int val2 = Character.getNumericValue(arr[1].charAt(i));
           // System.out.println(val1 | val2);
            currentBit = currentBit + (val1 | val2);
            System.out.println(currentBit+", ");
        }
        System.out.println();
        System.out.print(currentBit+", ");



    }
}
