package com.andreiko.switcher;

public class Lamp implements ElectricityConsumer{

    public void consumeElectricity() {
        turnOnLight();
    }

    public void turnOnLight(){
        System.out.println("Light is turned on.");
    }

}
