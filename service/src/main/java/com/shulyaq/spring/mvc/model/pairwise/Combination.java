package com.shulyaq.spring.mvc.model.pairwise;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Combination<T> {

    private List<Element<T>> values;

    public Combination() {
        this.values = new ArrayList<>();
    }

    public Combination(List<Element<T>> values) {
        this.values = values;
    }

    public void setValue(Element<T> value, int index) {
        values.set(index, value);
    }

    public void addValue(Element<T> value) {
        values.add(value);
    }

    public List<Element<T>> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Combination{" +
                "values=" + values +
                '}';
    }
}
