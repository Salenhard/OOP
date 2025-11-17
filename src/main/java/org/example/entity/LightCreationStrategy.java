package org.example.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class LightCreationStrategy implements EquipmentCreationStrategy {
    @Override
    public EquipmentModel create(String name) {
        EquipmentType light = new EquipmentType("light");
        EquipmentFunction turnOn = new EquipmentFunction("turnOn", new ArrayList<>());
        EquipmentFunction turnOff = new EquipmentFunction("turnOff", new ArrayList<>());
        EquipmentParameter brightness = new EquipmentParameter("brightness");
        brightness.setValues(Arrays.asList(new ParameterValue<>(100L)));
        light.setParameters(Arrays.asList(brightness));
        light.setFunctions(Arrays.asList(turnOn, turnOff));
        return new EquipmentModel(name, light);
    }
}
