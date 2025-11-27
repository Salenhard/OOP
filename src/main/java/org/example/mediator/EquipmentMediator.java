package org.example.mediator;

import org.example.factory.*;
import org.example.repository.*;
import org.example.entity.*;

public class EquipmentMediator {
    private final EquipmentFactory factory;
    private final EquipmentRepository repository;

    public EquipmentMediator(
            EquipmentFactory factory,
            EquipmentRepository repository
    ) {
        this.factory = factory;
        this.repository = repository;
    }

    public EquipmentModel addEquipmentModel(String type, String name) {
        EquipmentModel model = factory.create(type, name);
        repository.save(model);
        return model;
    }

}
