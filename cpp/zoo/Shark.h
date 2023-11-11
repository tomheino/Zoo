#pragma once
#include "Animal.h"
class Shark :
    public Animal
{
private:
    string species;
public:
    Shark(string name = "Jaws", Date birth = Date(), double weight = 150, string species = "GreatWhite");
    string getSpecies() { return species; }
    void setSpecies(string species) { this->species = species; }
    string toString() { return Animal::toString() + " Shark species: " + species; }
    void move();
    void utter();
};

