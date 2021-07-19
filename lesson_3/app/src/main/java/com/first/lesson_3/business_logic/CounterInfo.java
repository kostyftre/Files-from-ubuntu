package com.first.lesson_3.business_logic;

import java.io.Serializable;

public class CounterInfo implements Serializable {

    private int counter =0;

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }
}
