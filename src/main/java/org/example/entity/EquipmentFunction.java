package org.example.entity;

import java.util.List;
import java.util.Objects;

public class EquipmentFunction {
    private String name;
    private List<EquipmentParameter> parameters;

    public EquipmentFunction() {
    }

    public EquipmentFunction(String name, List<EquipmentParameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EquipmentParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<EquipmentParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentFunction that = (EquipmentFunction) o;
        return Objects.equals(name, that.name) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parameters);
    }
}
