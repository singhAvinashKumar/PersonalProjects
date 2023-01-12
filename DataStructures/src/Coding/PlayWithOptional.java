package Coding;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
public class PlayWithOptional {

    public static void main(String[] args) {
        Optional<String> word = Optional.empty();
        word.ifPresent(System.out::println);
        word.ifPresentOrElse(System.out::println,()-> System.out.println("from Runnable"));
        String s = word.orElseGet(() -> "Vishal");
        System.out.println(s);
        word.map(String::toUpperCase).ifPresent(System.out::println);
    }


}



