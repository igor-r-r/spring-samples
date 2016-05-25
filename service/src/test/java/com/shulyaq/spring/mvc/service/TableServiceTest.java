package com.shulyaq.spring.mvc.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shulyaq.spring.mvc.model.pairwise.Pair;
import com.shulyaq.spring.mvc.model.pairwise.Parameter;
import com.shulyaq.spring.mvc.model.pairwise.Parameters;
import com.shulyaq.spring.mvc.model.pairwise.Result;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TableServiceTest {

    private TableService service = new TableService();

    @Test
    public void testGetPairwise() throws Exception {
        Result allPairs = service.getPairwise(provideParameters());

        System.out.println();
    }

    @Test
    public void testGetAllCombinations() throws Exception {
        Result result = service.getAllCombinations(provideParameters());


        assertEquals(result, result);
    }

    @Test
    public void testJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{\n" +
                "  \"params\": [\n" +
                "    {\n" +
                "      \"name\": \"from\",\n" +
                "      \"values\": [\n" +
                "        \"USA\",\n" +
                "        \"Spain\",\n" +
                "        \"India\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"to\",\n" +
                "      \"values\": [\n" +
                "        \"Canada\",\n" +
                "        \"Mexico\",\n" +
                "        \"France\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

//JSON from file to Object
        Parameters obj = mapper.readValue(jsonInString, Parameters.class);
        System.out.println();
    }

    private Parameters provideParameters() {
        Parameter parameter1 = new Parameter("from", "USA", "India", "Philippines");
        Parameter parameter2 = new Parameter("to", "USA", "India", "Philippines");
//        Parameter parameter3 = new Parameter("class", "econom", "first", "business");
//        Parameter parameter4 = new Parameter("adults", "1", "2");
//        Parameter parameter5 = new Parameter("children", "0", "1", "m");

        return new Parameters(parameter1, parameter2);//, parameter3, parameter4, parameter5);
    }
}