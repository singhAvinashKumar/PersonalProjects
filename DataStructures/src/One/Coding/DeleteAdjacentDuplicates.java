package One.Coding;

public class DeleteAdjacentDuplicates {
    StringBuilder sb = new StringBuilder();
    String rremove(String s) {
        sb.append(s);
        if(sb.capacity()==0)
            return "";
        else{
            delDuplicates(s);
            return sb.toString();}
    }

    void delDuplicates(String s){
        if(s.length()==0)
            return;
        else if(s.length()==1)
            return;

        boolean duplicate = false;
        int startIndex = 0;
        int endIndex = 0;
        int counter = 0;
        int length = 0;
        StringBuilder crop = new StringBuilder();
        //int copyString = s;
        boolean isDeleted = false;
        for(int i = 0; i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1))
            {
                duplicate = true;
                crop.append(s.charAt(i));
                length++;
            }
            else
            {
                if (counter == 1)
                    {
                        crop.append(s.charAt(i));
                        length++;
                        startIndex = sb.indexOf(crop.toString());
              //          System.out.println(crop.toString());
                    }
                duplicate = false;
            }
            if(duplicate && counter<1)
            {
               // System.out.println(crop.toString()+", ");
                counter++;
            }
            else if(!duplicate && counter == 1)
            {
                endIndex = startIndex + length;
                //System.out.println("StartIndex : "+startIndex + " End Index "+ endIndex);
                counter = 0;
                //System.out.println("InDelete : "+ i);
                //System.out.println("Before : "+sb.toString());
                sb = sb.delete(startIndex,endIndex);
                crop = new StringBuilder();
                length = 0;
               // System.out.println("After : "+sb.toString());

                isDeleted = true;
            }

            if (duplicate && i==s.length()-2 )
            {
                crop.append(s.charAt(i+1));
                length++;
                startIndex = sb.indexOf(crop.toString());
                //System.out.println("Index :"+i+" Crop: "+crop.toString());
                endIndex = startIndex + length;
                //counter = 0;
                sb = sb.delete(startIndex,endIndex);
                isDeleted = true;
            }
        }
        if(isDeleted)
            delDuplicates(sb.toString());
    }

    public static void main(String[] args) {
        DeleteAdjacentDuplicates deleteAdjacentDuplicates = new DeleteAdjacentDuplicates();
        deleteAdjacentDuplicates.rremove("geeksforgeeks");
        System.out.println(deleteAdjacentDuplicates.sb.toString());;

    }
}
