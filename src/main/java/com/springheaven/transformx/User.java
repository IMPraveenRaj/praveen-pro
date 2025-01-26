package com.springheaven.transformx;

import java.math.BigDecimal;

public class User {

    Integer id;
    String name;
    Boolean active;
    Long salary;
    Double bonus;
    BigDecimal deposit;


    @Override
    public String toString() {
        return "User"+name+" ";
    }
}
