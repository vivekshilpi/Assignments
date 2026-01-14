package assignment3;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        HashMap<Integer, String> capMap = new HashMap<>(32);

        HashMap<Integer, String> loadMap = new HashMap<>(32, 0.75f);
        
        System.out.println("Put 1-Java: " + map.put(1, "Java"));
        System.out.println("PutIfAbsent 2-Python: " + map.putIfAbsent(2, "Python"));

        System.out.println("Get 1: " + map.get(1));
        System.out.println("GetOrDefault 3: " + map.getOrDefault(3, "Not Found"));

        System.out.println("Contains Key 1? " + map.containsKey(1));
        System.out.println("Contains Value Java? " + map.containsValue("Java"));

        System.out.println("Replace 2 with C++: " + map.replace(2, "C++"));

        System.out.println("Remove 1: " + map.remove(1));

        System.out.println("Size: " + map.size());

        System.out.println("KeySet: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("EntrySet: " + map.entrySet());

        map.putAll(new HashMap<>());
        map.compute(2, (k, v) -> v + " Language");
        System.out.println("After Compute: " + map);

        map.clear();
        
        System.out.println("Is Empty after clear? " + map.isEmpty());
    }
}