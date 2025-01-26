package com.springheaven.transformx.main;

import com.springheaven.transformx.hashex.Human;

public class Test {

    public static void main(String[] args) {
        Human human = new Human(1000,"Abhilash");
        System.out.println(human.name);
        //hashcode method in java is native method which means it has the implementaion of
        //the different language that why we are using the native keyword
        //native methods are also called the foreign methods
        //1595428806   hashcode are not the memory address
        //objects are created in heap but this is not the hashcode value
        // are not the address
        //1595428806
        //two different objects can have the same hashcode but
        //but the same objects can have the different hashcode
        int hashCodeValueofAbhilash = human.hashCode();
        System.out.println("Abhilash Hashcode value"+hashCodeValueofAbhilash);
        Human hashCodeValueofPraveen = new Human(1001,"PraveenRaj");
        System.out.println("Praveen HashCode Value"+hashCodeValueofPraveen.hashCode());

        String abhilash= new String("Abhilash");
        System.out.println(abhilash.hashCode());
        String praveen= new String("Praveen");
        System.out.println(praveen.hashCode());

    }
}
