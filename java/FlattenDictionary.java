package com.foxley.interview;

import java.util.HashMap;
import java.util.Map;

/**
 *  Date 08/20/2016
 *  @author Jecho Ricafrente
 *
 *      flattening a dictionary (hashMap objects) in java, recursively
 *
 *  Time complexity is O(n)
 *  Space complexity is O(n)    // since this example does not do in place
 */
public class FlattenDictionary {

    static Map<String,Object> map;

    public static void main(String[] args) {

        createMockup();
        map = flatten(map, new HashMap<String, Object>(), "");
        print();

        System.out.println("finish...");
    }

    public static Map<String, Object> flatten(Map<String, Object> map, Map<String, Object> curMap, String name) {

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object obj = entry.getValue();
            String newName;
            if (obj instanceof Map<?,?>) {
                if (name.isEmpty()) {
                    newName = name + entry.getKey();
                } else {
                    newName = name + "." + entry.getKey();
                }
                flatten((Map<String, Object> )obj, curMap, newName);
            } else {
                // it's not a dictionary, so probably a primative type
                newName = name + "." + entry.getKey();
                curMap.put(newName, entry.getValue());
            }
        }
        return curMap;
    }


    /*
        create fake dictionary items
     */
    public static void createMockup() {
        if (map == null) map = new HashMap<>();

        Map<String, Object> m1 = new HashMap();
        Map<String, Object> m2 = new HashMap();
        Map<String, Object> m3 = new HashMap();
        Map<String, Object> m1_1 = new HashMap();
        Map<String, Object> m2_1 = new HashMap();

        m1.put("a", 2);
        m1.put("b", 3);
        m1.put("c", m1_1);
        m2.put("d", 1);
        m2.put("e", 2);
        m3.put("f", 2);
        m3.put("g", 19);

        m1_1.put("c1", 13);
        m1_1.put("c2", 14);
        m1_1.put("c3", m2_1);
        m2_1.put("f1", 555);
        m2_1.put("f2", 777);

        map.put("x", m1);
        map.put("y", m2);
        map.put("z", m3);
    }

    public static void print() {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
