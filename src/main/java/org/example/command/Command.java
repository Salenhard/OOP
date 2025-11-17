package org.example.command;

public interface Command {
    Object execute();
    void undo();
}
