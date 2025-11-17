package org.example.entity;

import java.util.List;
import java.util.Objects;

public class EquipmentParameter {
    private String name;
    private List<ParameterValue> values;

    public EquipmentParameter() {
    }

    public EquipmentParameter(String name) {
        this.name = name;
    }

    public EquipmentParameter(String name, List<ParameterValue> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParameterValue> getValues() {
        return values;
    }

    public void setValues(List<ParameterValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentParameter that = (EquipmentParameter) o;
        return Objects.equals(name, that.name) && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, values);
    }
}
