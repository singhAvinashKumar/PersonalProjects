package Coding;

public class SwatNum_ReverseNum {


    public static void main(String[] args) {
        String revNumber = "12345";
        int num = 0;
        for( int i = 0 ; i<revNumber.length();i++){
            num = num * 10 + Character.getNumericValue(revNumber.charAt(i));
        }
        int revNum = 0;
        System.out.println(num);
        while (num > 0){
            revNum = revNum * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(revNum);

        int a = 20;
        int b = 30;

        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("A: "+a+" B "+b);


    }
}
