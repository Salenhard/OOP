package org.example.service;

import org.example.command.Command;
import org.example.command.SearchEquipmentCommand;
import org.example.repository.EquipmentRepository;

import java.util.Stack;

public class EquipmentService {
    private final EquipmentRepository repository;
    private final Stack<Command> undoStack = new Stack<>();

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public Object executeCommand(Command command) {
        Object result = command.execute();
        if (!(command instanceof SearchEquipmentCommand)) {
            undoStack.push(command);
        }
        return result;
    }

    public void undoLast() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
        } else {
            System.out.println("Нет команд для отмены");
        }
    }

    public void showHistory() {
        System.out.println("История операций (" + repository.getHistory().size() + "):");
        repository.getHistory().forEach(cmd ->
                System.out.println("  - " + cmd.getClass().getSimpleName())
        );
    }
}