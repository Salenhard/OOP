package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentType {
    private String name;
    private List<EquipmentFunction> functions = new ArrayList<>();
    private List<EquipmentParameter> parameters = new ArrayList<>();

    public EquipmentType() {
    }

    public EquipmentType(String name) {
        this.name = name;
    }

    public EquipmentType(String name, List<EquipmentFunction> functions, List<EquipmentParameter> parameters) {
        setName(name);
        setFunctions(functions);
        setParameters(parameters);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("Name can't be empty");
        this.name = name;
    }

    public List<EquipmentFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<EquipmentFunction> functions) {
        if (functions != null)
            this.functions = functions;
    }

    public List<EquipmentParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<EquipmentParameter> parameters) {
        if (parameters != null)
            this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentType that = (EquipmentType) o;
        return Objects.equals(name, that.name) && Objects.equals(functions, that.functions) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, functions, parameters);
    }
}
