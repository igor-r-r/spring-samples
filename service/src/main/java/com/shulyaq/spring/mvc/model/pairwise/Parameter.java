package com.shulyaq.spring.mvc.model.pairwise;

import java.util.List;

import static java.util.Arrays.asList;

public class Parameter implements Comparable<Parameter> {
    private String name;
    private List<String> values;

    public Parameter() {
    }

    public Parameter(String name, String... values) {
        this.name = name;
        this.values = asList(values);
    }

    public String getName() {
        return name;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public int compareTo(Parameter param) {
        return param.getValues().size() == this.values.size() ? 0
                : (param.getValues().size() == this.values.size() ? -1 : 1);
    }
}
