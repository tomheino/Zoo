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
public class Date {
    private int d;
    private int m;
    private int y;
    
    public Date(){
        this(1,1,2000);
    }
    public Date(int d, int m, int y){
        if (setValues(d,m,y) == false) {
            setValues(1, 1, 2022);
        }
    }

    static int MAX_VALID_YR = 2030;
    static int MIN_VALID_YR = 1900;

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", getY(),getM(),getD());
    }

    public boolean setValues(int d, int m, int y){
        if (!checkValues(d,m,y)) {
            return false;
        } else
        this.d = d;
        this.m = m;
        this.y = y;
        return true;
    }
    static boolean isLeap(int y)
    {
        // Return true if year is 
        // a multiple of 4 and not 
        // multiple of 100.
        // OR year is multiple of 400.
        return (((y % 4 == 0) && 
                 (y % 100 != 0)) || 
                 (y % 400 == 0));
    }

    public boolean checkValues(int d, int m, int y){
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


    /**
     * @return the d
     */
    public int getD() {
        return d;
    }

    /**
     * @return the m
     */
    public int getM() {
        return m;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
}
