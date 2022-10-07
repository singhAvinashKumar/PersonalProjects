package Coding;

import java.util.ArrayList;
import java.util.List;

public class PossibleCombination {

    static public List<String> letterCombinations(String digits) {

        String[] value = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] digitsValue = new String[5];
        List<String> combinations = new ArrayList<>();
        for(int i =0 ;i<digits.length();i++)
            digitsValue[i] = value[Character.getNumericValue(digits.charAt(i))];
        System.out.println(combinations.size());
        if(digits.length()==0)
            return combinations;

        for(int i = 0; i<digitsValue[0].length();i++)
            combinations.add(String.valueOf(digitsValue[0].charAt(i)));
        System.out.println(combinations.size());
        if(digits.length() >= 2){
            int size = combinations.size();
            for(int i = 0 ; i < size; i++){
                combinations.add(0,(combinations.get(i).concat(String.valueOf(digitsValue[1].charAt(0)))));
                combinations.add(1,(combinations.get(i).concat(String.valueOf(digitsValue[1].charAt(1)))));
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[1].charAt(2))));
                System.out.println("Size : " +digits.length()+" comb Size: "+combinations.size());

                if(digitsValue[1].length() == 4){
                    combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[1].charAt(3))));
                }
            }
        }


        if(digits.length() >= 3){
            int size = combinations.size();
            for(int i = 0; i<size;i++){
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[2].charAt(0))));
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[2].charAt(1))));
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[2].charAt(2))));
                System.out.println("Size : " +digits.length()+" comb Size: "+combinations.size());
                if(digitsValue[2].length() == 4)
                    combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[2].charAt(3))));
            }
        }

        if(digits.length()>=4){
            int size = combinations.size();
            for(int i = 0; i<size;i++){
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[3].charAt(0))));
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[3].charAt(1))));
                combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[3].charAt(2))));
                if(digitsValue[3].length() == 4)
                    combinations.add(combinations.get(i).concat(String.valueOf(digitsValue[3].charAt(3))));
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
