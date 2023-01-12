package Coding;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayWithRegeX {
    public static void main(String[] args) {

        System.out.println(Pattern.matches("([789])([\\d]){9}","7585850080"));
        System.out.println(Pattern.matches("[\\w\\d]+","2343wsfd334"));
        System.out.println(Pattern.matches("[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-zA-Z]+","Ping.2aks@gmail.com"));
        System.out.println(Pattern.matches("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$","L@1ravchenko"));

        Pattern pattern = Pattern.compile("[\\d\\W]");
        String[] words = pattern.split("Dan4iel#kfksld8KSDFj");
        Arrays.stream(words)
                .map(word-> word.substring(0,1).toUpperCase()+word.substring(1,word.length()))
                .forEach(System.out::println);
    }
}
