package com.shulyaq.spring.transform;

public interface DtoTransformer<S, R> {
    R transform(S source);
}
