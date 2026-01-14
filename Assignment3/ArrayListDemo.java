package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> capacityList = new ArrayList<>(20);
        ArrayList<String> initialList = new ArrayList<>(Arrays.asList("A", "B"));

        System.out.println("Add Apple: " + list.add("Apple"));
        list.add(0, "Banana");
        System.out.println("List after add(0, Banana): " + list);
        System.out.println("AddAll initialList: " + list.addAll(initialList));
        System.out.println("Size: " + list.size());
        System.out.println("Get index 1: " + list.get(1));
        System.out.println("Set index 1 to Cherry: " + list.set(1, "Cherry"));
        System.out.println("Contains Apple? " + list.contains("Apple"));
        System.out.println("Index of Cherry: " + list.indexOf("Cherry"));
        System.out.println("Remove Banana: " + list.remove("Banana"));
        System.out.println("Remove index 0: " + list.remove(0));
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println("To Array: " + Arrays.toString(list.toArray()));
        list.ensureCapacity(50);
        list.trimToSize();
        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
