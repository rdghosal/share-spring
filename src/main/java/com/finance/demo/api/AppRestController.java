package com.finance.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @Value("${api.key}")
    private String test;

    @GetMapping("/api")
    @JsonRawValue
    @JsonProperty(value="jsondata")
    public ResponseEntity<Json> test() {

        System.out.println(test);

        final HttpHeaders httpHeaders = new HttpHeaders();
        final Json json = new Json(test, 1);
        return new ResponseEntity<Json>(json, httpHeaders, HttpStatus.ACCEPTED);
    }

    class Json {
        public String jsonName;
        public int jsonNum;

        public Json(String name, int num) {
            jsonName = name;
            jsonNum = num;
        }
    }
}