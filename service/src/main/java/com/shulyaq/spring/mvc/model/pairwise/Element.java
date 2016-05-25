package com.shulyaq.spring.mvc.model.pairwise;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Element<T> {
    private String paramName;
    private T value;

    public Element() {
    }

    public Element(String paramName, T value) {
        this.paramName = paramName;
        this.value = value;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Element that = (Element) o;

        return new EqualsBuilder()
                .append(paramName, that.paramName)
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(paramName)
                .append(value)
                .toHashCode();
    }
}
