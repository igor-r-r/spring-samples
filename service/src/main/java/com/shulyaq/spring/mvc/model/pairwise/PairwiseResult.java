package com.shulyaq.spring.mvc.model.pairwise;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PairwiseResult implements Result {
    private Set<Combination> combinations;

    public PairwiseResult(Set<Combination> combinations) {
        this.combinations = combinations;
    }

    @Override
    public Set<Combination> getCombinations() {
        return combinations;
    }
}
