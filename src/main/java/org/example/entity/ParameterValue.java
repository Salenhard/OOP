package org.example.entity;

import java.util.Objects;

public class ParameterValue<T> {
    private T value;

    public ParameterValue() {
    }

    public ParameterValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParameterValue<?> that = (ParameterValue<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
