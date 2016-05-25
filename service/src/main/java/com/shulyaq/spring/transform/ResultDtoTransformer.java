package com.shulyaq.spring.transform;

import com.shulyaq.spring.model.ResultDto;
import com.shulyaq.spring.mvc.model.pairwise.Result;

public class ResultDtoTransformer implements DtoTransformer<Result, ResultDto> {
    public ResultDto transform(Result source) {
        return new ResultDto();
    }
}
