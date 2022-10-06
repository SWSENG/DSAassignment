/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donormaintaince;

/**
 *
 * @author HP
 */
public class Donor implements Comparable<Donor>{
    private int id;
    private static int idCounter = 1001;
    private String name;
    private char gender;
    private double donateAmount;
    private int day, month, year;
    
    public Donor() {
        this.name = "";
        this.gender = '\u0000';
        this.donateAmount = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }
    
    public Donor(String name, char gender, double donateAmount, int day, int month, int year) {
        this.id = idCounter++;
        this.name = name;
        this.gender = gender;
        this.donateAmount = donateAmount;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public char getGender() {
        return gender;
    }

    public double getDonateAmount() {
        return donateAmount;
    }

    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setId() {
        this.id = idCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }


    public void setDonateAmount(double donateAmount) {
        this.donateAmount = donateAmount;
    }

    public void setDonateDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }   

    @Override
    public String toString() {
        return ("ID:" + id + ", Name:" + name + ", Gender:" + gender + 
                ", Donate Amount:" + donateAmount + ", Donate Date:" + day + "-" + month + "-" + year);
    }

    @Override
    public int compareTo(Donor o) {
        return (int) (Math.round(this.donateAmount)-Math.round(o.donateAmount));
    }
}
