package assignment3;

import java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {

        Hashtable<String, Integer> table = new Hashtable<>();

        Hashtable<String, Integer> tableCap = new Hashtable<>(20);

        table.put("A", 1);
        table.put("B", 2);

        System.out.println("Table: " + table);

        System.out.println("Get A: " + table.get("A"));

        System.out.println("Contains value 1? " + table.contains(1));

        System.out.println("Contains Key B? " + table.containsKey("B"));

        System.out.println("Elements: " + table.elements());

        System.out.println("Keys: " + table.keys());

        System.out.println("Remove A: " + table.remove("A"));

        System.out.println("Is Empty: " + table.isEmpty());

        System.out.println("Size: " + table.size());

        System.out.println("String representation: " + table.toString());

        System.out.println("Hash Code: " + table.hashCode());
        System.out.println("PutIfAbsent C-3: " + table.putIfAbsent("C", 3));

        table.replace("B", 2, 20);
        System.out.println("After replace: " + table);
        
        table.clear();
    }
}