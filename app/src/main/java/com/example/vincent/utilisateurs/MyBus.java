package com.example.vincent.utilisateurs;

import com.squareup.otto.Bus;


public class MyBus {

    private static Bus bus = new Bus();

    public static Bus getBus(){
        return bus;
    }
}
