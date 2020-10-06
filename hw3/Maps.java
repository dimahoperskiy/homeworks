package com.hw.homeworks.hw3;

import java.util.*;

public class Maps {

    public static void sets(String str){
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        Map<Character, Integer> lettersMap = new HashMap<>();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            lettersMap.compute(ch, (k, v)->v==null?1:v+1);
        }
        ArrayList<Map.Entry<Character, Integer>> listToSort = new ArrayList<>(lettersMap.entrySet());
        listToSort.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for(Map.Entry<Character, Integer> entri: listToSort){
            System.out.println(entri.getKey() + " " + entri.getValue());
        }
    }


    public static <K, V> Map<V, HashSet<K>> revertMap(Map<? extends K, ? extends V> map){
        HashMap<V, HashSet<K>> mapFinal = new HashMap<>();
//        for (Map.Entry<? extends K, ? extends V> entry: mapToRevert.entrySet()){
//            map.put(entry.getValue(), entry.getKey());
//        }
        Set<K> keys = (Set<K>) map.keySet();
        for (K key: keys){
            V value = map.get(key);
            mapFinal.compute(value, (v, k) ->{
                if (k == null)
                    k = new HashSet<>();
                k.add(key);
                return k;
            });
        }
        return mapFinal;
    }

    public static <K,V> Map<V, HashSet<K>> revertMap(HashMap<K,V> mapToRevert) {
        HashMap<V,HashSet<K>> rev = new HashMap<>();
        for(Map.Entry<K,V> entry : mapToRevert.entrySet())
            rev.put(entry.getValue(), (HashSet<K>) entry.getKey());
        return rev;
    }


    public static void main(String[] args) {
        sets("hello world");

        HashMap <Integer, String> dict = new HashMap<>();
        dict.put(1, "first");
        dict.put(2, "second");
        dict.put(3, "third");
        System.out.println(revertMap(dict));


    }


}
