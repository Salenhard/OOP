package org.example.repository;

import org.example.command.Command;
import org.example.entity.EquipmentModel;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Работа с "базой данных" оборудования
 * В реальном проекте — это был бы JPA-репозиторий или DAO
 */
public class EquipmentRepository {
    private final Map<String, EquipmentModel> storage = new HashMap<>();
    private final Stack<Command> history = new Stack<>();

    public void save(EquipmentModel model) {
        storage.put(model.getName(), model);
    }

    public EquipmentModel findByName(String name) {
        return storage.get(name);
    }

    public List<EquipmentModel> findAll() {
        return new ArrayList<>(storage.values());
    }

    public List<EquipmentModel> searchByType(String type) {
        return storage.values().stream()
                .filter(m -> m.getType() != null && m.getType().getName().equals(type))
                .collect(Collectors.toList());
    }

    public void delete(String name) {
        storage.remove(name);
    }

    public void logToHistory(Command command) {
        history.push(command);
    }

    public Stack<Command> getHistory() {
        return history;
    }
}