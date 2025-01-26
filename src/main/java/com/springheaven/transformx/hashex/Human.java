package com.springheaven.transformx.hashex;

public class Human {

    public int aadhaarNumber;
    public String name;


    public Human(int aadhaarNumber, String name) {
        this.aadhaarNumber = aadhaarNumber;
        this.name = name;
    }

    @Override
    public int hashCode() {
        //lets write an own implementation for the hashcode
        //good hashcode implementation is returning the unique number for the different objects
        return this.aadhaarNumber;
    }
}
