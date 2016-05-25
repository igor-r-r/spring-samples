package com.shulyaq.spring.mvc.service;

import com.shulyaq.spring.mvc.model.pairwise.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TableService {

    public Result getPairwise(Parameters params) {
        List<Pair> allPairs = getAllPairs(params.getParams());
        List<Pair> coveredPairs = new ArrayList<>();

        return new PairwiseResult(new HashSet<>());
    }


    public Result getAllCombinations(Parameters params) {
        return recursiveFull(params);
    }

    private List<Pair> getAllPairs(List<Parameter> params) {
        List<Pair> allPairs = new ArrayList<>();

        for (Parameter currentParam : params) {
            for (String currentValue : currentParam.getValues()) {
                Element<String> currentElement = new Element<>();
                currentElement.setParamName(currentParam.getName());
                currentElement.setValue(currentValue);
                for (Parameter targetParam : params) {
                    if (!targetParam.getName().equals(currentParam.getName())) {
                        for (String targetValue : targetParam.getValues()) {
                            Element<String> targetElement = new Element<>();
                            targetElement.setParamName(targetParam.getName());
                            targetElement.setValue(targetValue);

                            Pair pair = new Pair(new Element[]{currentElement, targetElement});

                            if (!allPairs.contains(pair)) {
                                allPairs.add(pair);
                            }
                        }
                    }
                }
            }
        }

        return allPairs;
    }

    private Result recursiveFull(Parameters params) {
        List<Parameter> paramList = params.getParams();
        Set<Combination> combinations = build(paramList, 0, new ArrayList<Element<String>>(), new HashSet<Combination>());
        return new PairwiseResult(combinations);
    }

    private Set<Combination> build(List<Parameter> paramList, int index, List<Element<String>> values, Set<Combination> combinations) {
        if (index < paramList.size()) {
            Parameter param = paramList.get(index);
            for (String value : param.getValues()) {
                List<Element<String>> cloned = new ArrayList<>(values);
                cloned.add(new Element<>(param.getName(), value));
                build(paramList, index + 1, cloned, combinations);
            }
        } else {
            combinations.add(new Combination<>(values));
        }

        return combinations;
    }
}

