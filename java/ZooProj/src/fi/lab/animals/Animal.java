/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lab.animals;

import java.util.Comparator;

/**
 *
 * @author x104174 - Tommi Heino
 */
public abstract class Animal implements Comparable<Animal>{
    private String name;
    private Date birth;
    private double weight;

    public Animal(){
        this("AnAnimal", new Date(), 100.0);
    }
    public Animal(String name, Date birth, double weight){
        setName(name);
        setBirth(birth);
        setWeight(weight);
    }

    @Override
    public String toString() {
        return getName()+" "+getBirth()+" "+getWeight();
    }
    
    public abstract void move();
    public abstract void utter();
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth the birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static Comparator<Animal> AgeComparator = new Comparator<Animal>() {
    public int compare(Animal a1, Animal a2) {
        String s1 = a1.getBirth().toString();
        String s2 = a2.getBirth().toString();
        return s2.compareTo(s1);
    }
};
}

    

