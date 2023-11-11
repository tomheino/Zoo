// zoo.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Author: Tommi Heino - x104174
//

#include <iostream>
#include "Zoo.h"
#include "Tiger.h"
#include "Shark.h"
#include "Date.h"

using namespace std;

int main()
{
    Zoo zoo; // local object, default constructor
    // when function ends (main() in this case) all local objects destructor is called
    // --> zoo destructor
    // Zoo* pz = new Zoo();  // not necessary, the local Zoo object is fine
    // delete pz;
    zoo.print();
    zoo.printSortedByAge(true);
    zoo.printSortedByName();
    // zoo.add(new Animal());  // Animal is abstract
    Animal* pa = new Tiger();
    zoo.add(pa);
    pa->move();
    pa->utter();
    zoo.add(new Tiger("Temppa", Date(6,2,1995), 200, "Norwegian"));
    pa = zoo.remove("Temppa");
    if (pa) {
        cout << "Removed: " + pa->toString() << endl;
        delete pa;
    }
    zoo.print();
    zoo.printSortedByAge(true);
    zoo.printSortedByName();
    Animal* wa = new Shark();
    zoo.add(wa);
    zoo.add(new Shark("Alli", Date(30, 12, 2029), 620, "Hammerhead"));
    wa->move();
    wa->utter();
    zoo.printSortedByAge(false);
    zoo.printSortedByName();
    // finally zoo destructor is called automatically since zoo is a local object
}

Animal* Zoo::add(Animal* a)
{
    Animal* tmp = remove(a->getName());
    animals[a->getName()] = a;
    return tmp;
}

Animal* Zoo::remove(const string& name)
{
    Animal* tmp = 0;

    auto it = animals.find(name);
    if (it != animals.end()) {
        tmp = it->second;
        animals.erase(it);  // erases <k,v> and returns "index" to next <k,v>
    }
    return tmp;
}

void Zoo::print()
{
    // Same as printSortedByName(), because of Map -> already sorted
    printf("---------------- Animals -------------------\n");
    for (auto kv : animals) {
        printf("Key: %s Animal Value: %s\n", kv.first.c_str(), kv.second->toString().c_str());
    }
    printf("--------------------------------------------\n");
}

void Zoo::printSortedByName()
{
    printf("--------- Animals printed by name ----------\n");
    for (auto kv : animals) {
        printf("Key: %s Value: %s\n", kv.first.c_str(), kv.second->toString().c_str());
    }
    printf("--------------------------------------------\n");
}

void Zoo::printSortedByAge(bool ascending)
{
    // 1) create temp list and put all values to it
    list<Animal*> lp;
    for (auto it = animals.begin(); it != animals.end(); it++)
        lp.push_back(it->second);
    // 2) create a lambda function who acts as a binary (two input params) predicate for comparison
    //	(note: binary pred is needed because all sort algorithms use two value comparison)
    auto bpc = [&](Animal* a, Animal* b) {
        string s1 = a->getBirth().toString().c_str();
        string s2 = b->getBirth().toString().c_str();
        if (ascending)
            return s1 < s2;
        else return s1 > s2;
    };
    // 3) sort using the predicate
    lp.sort(bpc);
    // 4) print the list

    printf("---------- Animals printed by age ----------\n");
    if (ascending)
        printf("----------------- Ascending ----------------\n");
    else
        printf("----------------- Descending ---------------\n");
    for (auto a : lp) {
        printf("%s\n", a->toString().c_str());
    }
    printf("--------------------------------------------\n");
}

Zoo::~Zoo()
{
    // Delete all Animal objects and then erase from map
    for (auto it = animals.begin(); it != animals.end(); ) {
        delete it->second;
        // map<>::erase(par) where par can be either iterator or key
        it = animals.erase(it);
    }
}
