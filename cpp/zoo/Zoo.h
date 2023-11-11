#pragma once
#include <map>
#include <list>
#include "Animal.h"
class Zoo
{
private:
	map<string, Animal*> animals;
public:
	Animal* add(Animal* a);
	Animal* remove(const string& name);
	void print();
	void printSortedByName();
	void printSortedByAge(bool ascending = true);
	~Zoo();
};

