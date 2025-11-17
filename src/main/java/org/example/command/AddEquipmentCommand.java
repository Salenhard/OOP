package org.example.command;

import org.example.entity.EquipmentModel;
import org.example.factory.EquipmentFactory;
import org.example.repository.EquipmentRepository;

public class AddEquipmentCommand implements Command {
    private final EquipmentFactory factory;
    private final String type;
    private final String name;
    private final EquipmentRepository repository;
    private EquipmentModel addedModel;

    public AddEquipmentCommand(EquipmentRepository repository, EquipmentFactory factory, String type, String name) {
        this.repository = repository;
        this.factory = factory;
        this.type = type;
        this.name = name;
    }

    @Override
    public Object execute() {
        addedModel = factory.create(type, name);
        repository.save(addedModel);
        repository.logToHistory(this);
        System.out.println("Добавлено: " + name + " (тип: " + type + ")");
        return addedModel;
    }

    @Override
    public void undo() {
        if (addedModel != null) {
            repository.delete(addedModel.getName());
            System.out.println("Отменено добавление: " + name);
        }
    }
}
