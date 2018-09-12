package com.andreiko.switcher;

import java.util.ArrayList;
import java.util.List;

public class Switcher {
    private List<ElectricityConsumer> consumers = new ArrayList<>();

    public void switchOn(){
        for (ElectricityConsumer consumer : consumers)
        if (consumer != null){
            consumer.consumeElectricity();
        }

    }
    public void addConsumer(ElectricityConsumer consumer) {
        consumers.add(consumer);
    }


}
