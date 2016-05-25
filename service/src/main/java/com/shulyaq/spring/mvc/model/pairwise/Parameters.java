package com.shulyaq.spring.mvc.model.pairwise;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Parameters {

    private List<Parameter> params;

    public Parameters() {
    }

    public Parameters(@JsonProperty("params") List<Parameter> params) {
        this.params = params;
    }

    public Parameters(Parameter... params) {
        this.params = Arrays.asList(params);
    }

    public List<Parameter> getParams() {
        return params;
    }

    public void setParams(List<Parameter> params) {
        this.params = params;
    }

    public void addParams(Collection<Parameter> params) {
        this.params.addAll(params);
    }
}
