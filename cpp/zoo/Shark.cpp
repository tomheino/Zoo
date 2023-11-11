#include "Shark.h"
#include <iostream>

Shark::Shark(string name, Date birth, double weight, string species)
	: Animal(name,birth,weight)
{
	setSpecies(species);
}

void Shark::move()
{
	cout << "Flipflipflipflipflip - Shark!" << endl;
}

void Shark::utter()
{
	cout << "KAKAKAKAKAKAKAKAKAKAKA! - Shark!" << endl;
}
