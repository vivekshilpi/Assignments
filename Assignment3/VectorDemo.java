package assignment3;

import java.util.Vector;
import java.util.Arrays;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>(10);
        Vector<Integer> v3 = new Vector<>(10, 5);
        Vector<Integer> v4 = new Vector<>(Arrays.asList(1, 2, 3));

        v1.add(10);
        v1.addElement(20);
        v1.insertElementAt(5, 0);
        System.out.println("Vector: " + v1);
        System.out.println("First: " + v1.firstElement());
        System.out.println("Last: " + v1.lastElement());
        System.out.println("Capacity: " + v1.capacity());
        v1.setSize(5);
        System.out.println("After setSize(5): " + v1);
        v1.setElementAt(100, 1);
        System.out.println("Remove element 10: " + v1.removeElement(10));
        v1.removeElementAt(0);
        System.out.println("Element at 0: " + v1.elementAt(0));
        Object[] arr = new Object[5];
        v1.copyInto(arr);
        System.out.println("Copied Array: " + Arrays.toString(arr));
        v1.trimToSize();
        System.out.println("Is Empty: " + v1.isEmpty());
        v1.removeAllElements();
        System.out.println("Size after removeAll: " + v1.size());
    }
}