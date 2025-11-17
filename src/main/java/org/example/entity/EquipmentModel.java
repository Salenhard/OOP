package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class EquipmentModel {
    private String name;
    private EquipmentType type;
    private List<EquipmentFunction> functions = new ArrayList<>();
    private List<EquipmentParameter> parameters = new ArrayList<>();

    public EquipmentModel() {
    }

    public EquipmentModel(String name, EquipmentType type) {
        this.name = name;
        this.type = type;
    }

    public EquipmentModel(String name, EquipmentType type, List<EquipmentFunction> functions, List<EquipmentParameter> parameters) {
        this.name = name;
        this.type = type;
        this.functions = functions;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public List<EquipmentFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<EquipmentFunction> functions) {
        this.functions = functions;
    }

    public List<EquipmentParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<EquipmentParameter> parameters) {
        this.parameters = parameters;
    }
}
