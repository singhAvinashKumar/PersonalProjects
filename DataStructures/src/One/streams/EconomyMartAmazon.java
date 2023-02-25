package One.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EconomyMartAmazon {
    static List<Product> items = new ArrayList<>();
    static List<String> views = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>>  entries = new ArrayList<List<String>>();
        List<String> itemsList1 = new ArrayList<>();
        itemsList1.add("INSERT");
        itemsList1.add("milk");
        itemsList1.add("4");
        List<String> itemsList2 = new ArrayList<>();
        itemsList2.add("INSERT");
        itemsList2.add("coffee");
        itemsList2.add("3");
        List<String> itemsList3 = new ArrayList<>();
        itemsList3.add("VIEW");
        itemsList3.add("-");
        itemsList3.add("-");
        List<String> itemsList4 = new ArrayList<>();
        itemsList4.add("INSERT");
        itemsList4.add("pizza");
        itemsList4.add("5");
        List<String> itemsList5 = new ArrayList<>();
        itemsList5.add("INSERT");
        itemsList5.add("gum");
        itemsList5.add("1");
        List<String> itemsList6 = new ArrayList<>();
        itemsList6.add("VIEW");
        itemsList6.add("-");
        itemsList6.add("-");
        entries.add(itemsList1);
        entries.add(itemsList2);
        entries.add(itemsList3);
        entries.add(itemsList4);
        entries.add(itemsList5);
        entries.add(itemsList6);
        getItems(entries);
    }

    static void getItems(List<List<String>> entries){
        int count = 0;
        for (List<String> entry : entries){
            if (entry.get(0).equals("INSERT")){
                items.add(new Product(Integer.parseInt(entry.get(2)),entry.get(1)));
                items = items.stream().sorted((o1, o2) -> o1.price-o2.price).collect(Collectors.toList());
            }

            if (entry.get(0).equals("VIEW"))
                views.add(items.get(count++).name);
        }
        views.forEach(System.out::println);
    }
    }
    

class Product  {
    Integer price;
    String name;
    Product(Integer price , String name){
        this.price = price;
        this.name =name;
    }

}

