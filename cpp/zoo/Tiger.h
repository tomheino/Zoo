#pragma once
#include "Animal.h"
class Tiger :
    public Animal
{
private:
    string species;
public:
    Tiger(string name = "Woods", Date birth = Date(), double weight = 150, string species = "Indian");
    string getSpecies() { return species; }
    void setSpecies(string species) { this->species = species; }
    string toString() { return Animal::toString() + " Tiger species: " + species; }
    void move();
    void utter();
};

