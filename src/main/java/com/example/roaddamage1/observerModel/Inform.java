package com.example.roaddamage1.observerModel;

import java.util.Observable;
import java.util.Observer;

public class Inform extends Observable {

    public  void change(){
        this.setChanged();
    }


//   调用方法：    ob1 observer1 = new ob1("STATE1");
//        ob1 observer2 = new ob1("STATE2");
//
//       Inform inform =  new Inform();
//       inform.addObserver(observer1);
//       inform.addObserver(observer2);
//       inform.change();
//       inform.notifyObservers("stat1");

}
