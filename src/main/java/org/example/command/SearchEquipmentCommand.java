package org.example.command;

import org.example.entity.EquipmentModel;
import org.example.repository.EquipmentRepository;

import java.util.List;

public class SearchEquipmentCommand implements Command {
    private final EquipmentRepository repository;
    private final String searchType;
    private final String query;

    public SearchEquipmentCommand(EquipmentRepository repository, String searchType, String query) {
        this.repository = repository;
        this.searchType = searchType;
        this.query = query;
    }

    @Override
    public Object execute() {
        List<EquipmentModel> results;

        switch (searchType.toLowerCase()) {
            case "bytype":
                results = repository.searchByType(query);
                System.out.println("🔍 Поиск по типу '" + query + "': найдено " + results.size());
                break;
            case "all":
                results = repository.findAll();
                System.out.println("📋 Все оборудование: " + results.size() + " записей");
                break;
            default:
                results = repository.findAll();
        }

        results.forEach(m ->
                System.out.println("  - " + m.getName() + " [" + m.getType().getName() + "]")
        );

        return results;
    }

    @Override
    public void undo() {
        // Поиск не имеет состояния для отмены
        System.out.println("⚠ Поиск нельзя отменить");
    }
}
