/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lab.animals;

/**
 *
 * @author x104174 - Tommi Heino
 */
public class Tiger extends Animal {
    String species;

    //private String species;
    
    public Tiger(){
        this("Woods", new Date(), 150, "Indian");
    }
    public Tiger(String name, Date birth, double weight, String species){
        // hint: call parent constructor first with name,birth,weight
        super(name, birth, weight);
        setSpecies(species);
    }

    @Override
    public String toString() {
        return super.toString() + " "+getSpecies();
    }
    
    
    
    @Override
    public void move() {
        System.out.println("SHUSHUSHUSHUSHU - Tiger!");
    }

    @Override
    public void utter() {
        System.out.println("ROAARRRRRRRR - Tiger!");
    }

    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }
    @Override
    public int compareTo(Animal o) {
        String s1 = this.getBirth().toString();
        String s2 = o.getBirth().toString();
        return s2.compareToIgnoreCase(s1);
    }
}
