#include "Tiger.h"
#include <iostream>

Tiger::Tiger(string name, Date birth, double weight, string species)
	: Animal(name,birth,weight)
{
	setSpecies(species);
}

void Tiger::move()
{
	cout << "SHUSHUSHUSHUSHU - Tiger!" << endl;
}

void Tiger::utter()
{
	cout << "ROAARRRRRRRR - Tiger!" << endl;
}
