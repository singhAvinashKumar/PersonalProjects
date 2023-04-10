package One.Coding;

import java.util.regex.Pattern;

public class ToCamelCase {

    public static void main(String[] args) {
        String word = "A WondweRfull#new@worlD";
        toCamelCaseUpper(word);
    }

    private static void toCamelCaseUpper(String word) {
        int counter = 0;
        char[] ch = word.toCharArray();
        int size = word.length();
        Pattern pattern = Pattern.compile("\\W");
        String[] split = pattern.split(word);
        String result = "";
        for (String s : split) {
            String lowerCase = s.toLowerCase();
            char c = lowerCase.charAt(0);
            //result = result + lowerCase.toUpperCase();
//            result = result + lowerCase.replace(lowerCase.charAt(0),Character.toUpperCase(c));
            result = result + Character.toUpperCase(c) + lowerCase.substring(1) ;
//            result = result + lowerCase.replace(c, Character.toUpperCase(c));
            System.out.println(result);
        }
        System.out.println(result);
    }
}
