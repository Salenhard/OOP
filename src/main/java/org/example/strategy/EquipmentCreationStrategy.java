package org.example.strategy;

import org.example.entity.EquipmentModel;

public interface EquipmentCreationStrategy {
    EquipmentModel create(String name);
}
