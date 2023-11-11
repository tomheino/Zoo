/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Author: Tommi Heino - x104174
 */
package fi.lab.animals;

/**
 *
 * @author x104174 - Tommi Heino
 */
public class ZooProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.print();
        // zoo.add(new Animal()); // Animal is abstract class --> cannot be instantiated
        
        Animal a = new Tiger("Teuvo", new Date(1,2,2000), 300, "Siberian");
        zoo.add(a);
        a.move();   // polymorphistic call: Tiger.move()
        a.utter();  // polymorphistic call: Tiger.utter()
        zoo.add(new Shark());
        zoo.add(new Tiger());
        zoo.print();
        
        zoo.printSortedByName();
        String n = "Teuvo";
        Animal al = zoo.remove(n);
        if(al != null)
            System.out.println("Removed by name '"+n+"': "+al);
        else
            System.out.println("No animal '"+n+"' found!");
        
        Animal a2 = new Tiger("Atte", new Date(5,11,2031), 360, "Alaskan");
        zoo.add(a2);
        Animal a3 = new Shark("Alli", new Date(3,2,2002), 520, "Hammerhead");
        a3.move();
        a3.utter();
        zoo.add(a3);
        zoo.printSortedByName();
        zoo.printSortedByAge();
        zoo.print();

    }
    
}
