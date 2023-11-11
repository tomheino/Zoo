#pragma once
#include <string>
using namespace std;
#include "Date.h"
class Animal
{
private:
	string name;
	Date birth;
	double weight;
public:
	Animal(string name = "AnAnimal", Date birth = Date(), double weight = 100);
	string getName() { return name; }
	void setName(string name) { this->name = name; }
	Date getBirth() { return birth; }
	void setBirth(Date birth) { this->birth = birth; }
	double getWeight() { return weight; }
	void setWeight(double weight) { this->weight = weight; }
	virtual string toString() { return name + " birth: " + birth.toString() + " weight: " + to_string(weight); }
	virtual void move() = 0;	// "=0" --> pure virtual --> no definition --> the class Animal is abstract
	virtual void utter() = 0;
	virtual ~Animal();
};

