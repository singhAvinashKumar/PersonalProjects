package Coding;

import java.util.HashMap;
import java.util.Map;

public class BalancedStringSplitAmazon {

    public static void main(String[] args) {
        String s = "[(?][??[";
        System.out.println(fillMissingBracket(s));
    }
    

    static public int fillMissingBracket(String s){
        int length = s.length();
        int count = 0;
        for (int i =1 ; i < length-1; i++){
            if (isBalanced(s.substring(0,i+1)));
            {
                if (isBalanced(s.substring(i+1,length)))
                    count++;
            }
        }
        return count;
    }
    public static boolean isBalanced(String s){
        boolean isBalanced = false;
        int smallOpen = 0;
        int smallClose = 0;
        int bigOpen = 0;
        int bigClose = 0;
        int questionMark = 0;
        int required = 0;

        for (int i = 0; i < s.length(); i++ ){
            switch (s.charAt(i)){
                case '[' : bigOpen++;
                break;
                case ']' : bigClose++;
                break;
                case '(' : smallOpen++;
                break;
                case ')' : smallClose++;
                break;
                case '?' : questionMark++;
            }
        }
        if ( bigOpen > bigClose )
                required = required + (bigOpen - bigClose);
        else if ( bigOpen < bigClose)
                    required = required + (bigClose-bigOpen);

        if (  smallOpen > smallClose )
            required = required + (smallOpen - smallClose);
        else if ( smallOpen < smallClose)
            required = required + (smallClose-smallOpen);

        if (required == questionMark)
            isBalanced = true;
        return isBalanced;
    }
}
