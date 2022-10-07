package Coding;

import java.util.HashSet;
import java.util.Set;

public class StringSmallestWIndow {

    public static String smallestWindow(String s, String p)
    {
        int counter = p.length();
        Set<Character> window = new HashSet<>();
        Set<Character> pSet = new HashSet<>();
        StringBuilder sbWindow = new StringBuilder();
        int startIndex = 0;
        int endIndex = 0;
        boolean active = false;
        for(int i = 0; i<p.length(); i++)
            pSet.add(p.charAt(i));

        for(int i = 0; i<s.length(); i++){
            if (counter<=0)
                {
                    endIndex = i - 1;
                    break;
                }
            if(pSet.contains(s.charAt(i))){
                if (window.size() == 1 && window.contains(s.charAt(i)))
                    {
                        startIndex = i;
                        sbWindow = new StringBuilder(String.valueOf(s.charAt(i)));
                        continue;
                    }
                active = true;
                if (!(window.contains(s.charAt(i))))
                    counter--;
                window.add(s.charAt(i));
            }
            if(active){
                sbWindow.append(s.charAt(i));
                //System.out.println(sbWindow.toString());
            }

        }

     // return   s.substring(startIndex,endIndex+1);
        return sbWindow.toString();
    }
    public static void main(String[] args) {
    String result =  smallestWindow("zoomlazapzo","oza");
        System.out.println(result);
    }

}
