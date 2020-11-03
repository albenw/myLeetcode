package com.albenw.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020-08-25.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<String, Integer> map1 = constructCountMap(s);
        Map<String, Integer> map2 = constructCountMap(t);
        return mapIsEqual(map1, map2);
    }

    private Map<String, Integer> constructCountMap(String str){
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(String.valueOf(str.charAt(i)))){
                Integer count = map.get(String.valueOf(str.charAt(i)));
                map.put(String.valueOf(str.charAt(i)), ++count);
            }else{
                map.put(String.valueOf(str.charAt(i)), 1);
            }
        }
        return map;
    }

    private boolean mapIsEqual(Map<String, Integer> map1, Map<String, Integer> map2){
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(!map2.containsKey(entry.getKey()) || !entry.getValue().equals(map2.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean anagram = validAnagram.isAnagram("cat", "cat");
        assert anagram;
    }
}
