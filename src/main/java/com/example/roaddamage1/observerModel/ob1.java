package com.example.roaddamage1.observerModel;

import java.util.Observable;
import java.util.Observer;

public class ob1 implements Observer {
    private String state;

    public ob1(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
