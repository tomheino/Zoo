/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lab.animals;

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 *
 * @author x104174 - Tommi Heino
 */
public class Zoo {
    private Map<String,Animal> animals = new TreeMap<>();
    
    public Animal add(Animal a){
        return animals.put(a.getName(), a); // put() returns previous value by the key or null
    }
    public Animal remove(String name){
        return animals.remove(name);
    }
    
    public void print(){
        System.out.println("------------------------ Animals -----------------------");
        // Same as printSortedByName -> TreeMap sorts automatically based on k,v.
        animals.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));

        // Different way using iterator
        // for(Iterator<Map.Entry<String,Animal>> ime = animals.entrySet().iterator() ; ime.hasNext() ;) {
        //     Map.Entry<String,Animal> e = ime.next();
        //     System.out.println("Key: "+e.getKey()+" Value: "+e.getValue());
            System.out.println("--------------------- eof Animals ----------------------");
        }
    
    
    public void printSortedByName(){
        System.out.println("---------------- Animals sorted by name ----------------");
        animals.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));
        System.out.println("-------------- eof Animals sorted by name --------------");
    }

    public void printSortedByAge(){
    List<Animal> animals2 = new ArrayList<Animal>();
    animals.forEach((k,v) -> animals2.add(v));
    new Comparator<Animal>() {
        public int compare(Animal a1, Animal a2) {
            String s1 = a1.getBirth().toString();
            String s2 = a2.getBirth().toString();
            return s2.compareTo(s1);
        }
    };
    Collections.sort(animals2, Animal.AgeComparator);
        System.out.println("---------------- Animals sorted by age -----------------");
        animals2.stream().sorted().forEach(System.out::println);
        System.out.println("-------------- eof Animals sorted by age ---------------");
    }
}


