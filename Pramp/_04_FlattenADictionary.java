package com.mert.Pramp;

import java.util.*;

public class _04_FlattenADictionary {


    public static void main(String[] args) {

        HashMap<String, Object> map = createHashMap();
        HashMap<String, String> ansMap = new HashMap();

        recursiveFunc("", ansMap, map);

        System.out.println(ansMap);
        System.out.print(map);
    }

    public static void recursiveFunc(String initialKey, HashMap<String, String> ansMap, HashMap<String, Object> dict) {
        for(String key : dict.keySet()) {            
            if(dict.get(key) instanceof String){                
                if(key.isEmpty() || initialKey.isEmpty())
                    ansMap.put(initialKey + key, String.valueOf(dict.get(key)));
                else
                    ansMap.put(initialKey + "." + key, String.valueOf(dict.get(key)));
            } else {
                if(initialKey.isEmpty())
                    recursiveFunc(key, ansMap, (HashMap)dict.get(key));
                else
                    recursiveFunc(initialKey + "." + key, ansMap, (HashMap)dict.get(key));
            }
        }
    }


    public static HashMap<String, Object> createHashMap(){
        HashMap<String, Object> map = new HashMap();
        HashMap<String, Object> myObject = new HashMap();
        HashMap<String, Object> myObject2 = new HashMap();
        HashMap<String, Object> myObject3 = new HashMap();

        myObject3.put("", "1");

        myObject2.put("d", "3");
        myObject2.put("e", myObject3);

        myObject.put("a", "2");
        myObject.put("b", "2");
        myObject.put("c", myObject2);


        map.put("Key1", "1");
        map.put("Key2", myObject);


        return map;
    }
    
}




/*
  Flatten a Dictionary
A dictionary is a type of data structure that is supported natively in all major interpreted languages such 
as JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively.
 In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of
  any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be 
  nested). However, for this exercise assume that values are either an integer, a string or another dictionary.
  
 Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .

If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash
Table that maps strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.

If a certain key is empty, it should be excluded from the output (see e in the example below).

input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }




 */
