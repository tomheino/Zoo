#include "Date.h"
#include <iostream>

const int MAX_VALID_YR = 2030;
const int MIN_VALID_YR = 1900;

Date::Date(int d, int m, int y)
{
    if (!setValues(d, m, y)) {
        setValues(1, 1, 2022);
    }
}

bool Date::isLeap(int y) {
    return (((y % 4 == 0) &&
        (y % 100 != 0)) ||
        (y % 400 == 0));
}

bool Date::checkValues(int d, int m, int y)
{
    // If year, month and day 
    // are not in given range
    if (y > MAX_VALID_YR ||
        y < MIN_VALID_YR)
        return false;
    if (m < 1 || m > 12)
        return false;
    if (d < 1 || d > 31)
        return false;

    // Handle February month 
    // with leap year
    if (m == 2)
    {
        if (isLeap(y))
            return (d <= 29);
        else
            return (d <= 28);
    }

    // Months of April, June, 
    // Sept and Nov must have 
    // number of days less than
    // or equal to 30.
    if (m == 4 || m == 6 ||
        m == 9 || m == 11)
        return (d <= 30);

    return true;
} 


bool Date::setValues(int d, int m, int y)
{
    if (!checkValues(d, m, y)) return false;
    this->d = d;
    this->m = m;
    this->y = y;
    return true;
}
