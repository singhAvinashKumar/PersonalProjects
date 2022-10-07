package Coding;

public class LongestPalindrome {
    static int startIndex;
    static int stringLength;
     public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        for(int i = 0; i<s.length()-1; i++){

            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        //System.out.println("start : "+ startIndex +" length : "+ stringLength);
        return s.substring(startIndex, startIndex + stringLength);

    }

    static void isPalindrome(String S, int a,int b){
        while(a>=0 && b< S.length() && S.charAt(a) == S.charAt(b)){
            b++;
            a--;

        }
        if((b-a-1)> stringLength)
        {
            stringLength = b-a-1;
            startIndex = a+1;
        }

    }

    public static void main(String[] args) {
         LongestPalindrome longest = new LongestPalindrome();
        System.out.println(longest.longestPalindrome("cbbd"));;
    }
}
