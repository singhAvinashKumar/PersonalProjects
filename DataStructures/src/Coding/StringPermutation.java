package Coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringPermutation {

    List<String> result = new ArrayList<>();

    public List<String> find_permutation(String S) {
        if(S.length()<2)
        {
            result.add(S);
            return result;
        }
        result = computePermutation(S);
        result.sort(String::compareTo);
        return result;
    }

    public List<String> computePermutation(String s){

        StringBuilder sb = new StringBuilder(s);
        List<String> tempList = new ArrayList<>();
        List<String> finalList = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        if(s.length()==2)
            return permuteTwo(s);

        for( int i = 0; i<s.length(); i++){
            if(set.contains(s.charAt(i)))
                continue;

            set.add(s.charAt(i));
            StringBuilder tempSb = new StringBuilder(s);
            //System.out.println(sb + " "+i);
            String temp = tempSb.deleteCharAt(i).toString();
            //System.out.println("temp : "+temp);
            final String current = String.valueOf(s.charAt(i));
            tempList = computePermutation(temp);
            //tempList.forEach(System.out::println);
            tempList = tempList.stream().map(o -> o = current + o).collect(Collectors.toList());
            finalList.addAll(tempList);
            /*finalList.forEach(System.out::print);
            System.out.println();*/
        }
        return finalList;
    }

    public List<String> permuteTwo(String s){
        List<String> list = new ArrayList<>();
        String a = String.valueOf(s.charAt(0));
        String b = String.valueOf(s.charAt(1));
        if(a.equals(b))
        {
            list.add(a+b);
            return list;
        }
        list.add(a+b);
        list.add(b+a);
        return list;
    }

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
         permutation.find_permutation("ABCD").forEach(System.out::println);

    }
}
