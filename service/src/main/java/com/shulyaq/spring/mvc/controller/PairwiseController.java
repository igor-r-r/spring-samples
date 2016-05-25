package com.shulyaq.spring.mvc.controller;

import com.shulyaq.spring.mvc.model.pairwise.Parameters;
import com.shulyaq.spring.mvc.model.pairwise.Result;
import com.shulyaq.spring.mvc.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PairwiseController {
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/pairwise", method = POST)
    public Result getPairwise(@RequestBody Parameters parameters) {
        return tableService.getPairwise(parameters);
    }

    @RequestMapping(value = "/full", method = POST, produces = "application/json",
            consumes = "application/json")
    public Result getAllCombinations(@RequestBody Parameters parameters) {
        return tableService.getAllCombinations(parameters);
    }

    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }
}
