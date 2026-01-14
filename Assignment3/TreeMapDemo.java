package assignment3;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<>();

        tree.put(10, "Ten");
        tree.put(5, "Five");
        tree.put(20, "Twenty");

        System.out.println("TreeMap: " + tree);

        System.out.println("First Key: " + tree.firstKey());
        System.out.println("Last Key: " + tree.lastKey());

        System.out.println("Ceiling Key 8: " + tree.ceilingKey(8));
        System.out.println("Floor Key 8: " + tree.floorKey(8));

        System.out.println("Higher Key 10: " + tree.higherKey(10));
        System.out.println("Lower Key 10: " + tree.lowerKey(10));

        System.out.println("Poll First: " + tree.pollFirstEntry());
        System.out.println("Poll Last: " + tree.pollLastEntry());

        System.out.println("Descending Map: " + tree.descendingMap());

        System.out.println("HeadMap 15: " + tree.headMap(15));
        System.out.println("TailMap 15: " + tree.tailMap(15));
        System.out.println("SubMap 1 to 25: " + tree.subMap(1, 25));

        System.out.println("Replace 10: " + tree.replace(10, "New Ten"));
        System.out.println("Final Size: " + tree.size());
    }
}