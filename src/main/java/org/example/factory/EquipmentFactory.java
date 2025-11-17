package org.example.factory;

import org.example.entity.EquipmentModel;
import org.example.strategy.EquipmentCreationStrategy;
import org.example.strategy.LightCreationStrategy;
import org.example.strategy.PumpCreationStrategy;

import java.util.HashMap;
import java.util.Map;

public class EquipmentFactory {
    private final Map<String, EquipmentCreationStrategy> strategies = new HashMap<>();

    public EquipmentFactory() {
        register("light", new LightCreationStrategy());
        register("pump", new PumpCreationStrategy());
    }

    public EquipmentModel create(String type, String name) {
        EquipmentCreationStrategy strategy = strategies.get(type.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
        return strategy.create(name);
    }

    public void register(String type, EquipmentCreationStrategy strategy) {
        strategies.put(type.toLowerCase(), strategy);
    }

}
