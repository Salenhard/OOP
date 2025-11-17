package org.example.command;

import org.example.entity.EquipmentModel;
import org.example.repository.EquipmentRepository;

public class DeleteEquipmentCommand implements Command {
    private final EquipmentRepository repository;
    private final String name;
    private EquipmentModel deletedModel;

    public DeleteEquipmentCommand(EquipmentRepository repository, String name) {
        this.repository = repository;
        this.name = name;
    }

    @Override
    public Object execute() {
        deletedModel = repository.findByName(name);
        if (deletedModel != null) {
            repository.delete(name);
            repository.logToHistory(this);
            System.out.println("✗ Удалено: " + name);
        } else {
            System.out.println("✗ Ошибка: оборудование не найдено — " + name);
        }
        return deletedModel;
    }

    @Override
    public void undo() {
        if (deletedModel != null) {
            repository.save(deletedModel);
            System.out.println("✓ Восстановлено: " + name);
        }
    }
}