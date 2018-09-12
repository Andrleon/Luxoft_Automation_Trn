package com.luxoft.trn.automation;

public class Program {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Switcher switcher = new Switcher();

        switcher.addConsumer(() -> System.out.println("Light is on"));
        switcher.addConsumer(lamp);
        switcher.switchOn();

    }
}
