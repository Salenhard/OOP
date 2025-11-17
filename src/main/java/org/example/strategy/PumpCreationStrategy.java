package org.example.strategy;

import org.example.entity.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PumpCreationStrategy implements EquipmentCreationStrategy {

    @Override
    public EquipmentModel create(String name) {
        EquipmentType pump = new EquipmentType("pump");
        EquipmentFunction turnOn = new EquipmentFunction("turnOn", new ArrayList<>());
        EquipmentFunction turnOff = new EquipmentFunction("turnOff", new ArrayList<>());
        EquipmentParameter power = new EquipmentParameter("power");
        power.setValues(Arrays.asList(new ParameterValue<>(100L)));
        pump.setParameters(Arrays.asList(power));
        pump.setFunctions(Arrays.asList(turnOn, turnOff));
        return new EquipmentModel(name, pump);
    }
}
