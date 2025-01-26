package com.springheaven.transformx.constructorchaining;

public class A {

     A(){

        System.out.println("Inside default constructor");
    }

    A(int i){
         this(i,3.0);
        System.out.println("inside int constructor"+i);
    }

    A(int i, double j){
        System.out.println("double param inside constructor"+i+"J "+j);

    }

    public static void main(String[] args) {
        A a = new A(10);
    }



}
