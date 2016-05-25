package com.shulyaq.spring.mvc.model.pairwise;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import static java.util.Arrays.asList;

public class Pair {
    private Element[] elements = new Element[2];

    public Pair(Element[] elements) {
        this.elements = elements;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return asList(pair.elements).containsAll(asList(this.elements));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(elements)
                .toHashCode();
    }
}
