#include "Animal.h"

Animal::Animal(string name, Date birth, double weight)
//	: name(name), birth(birth), weight(weight)
{
	setName(name);
	setBirth(birth);
	setWeight(weight);
}

Animal::~Animal()
{
}
