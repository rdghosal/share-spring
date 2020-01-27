package com.finance.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/api")
    public ResponseEntity<Json> test() {

        String test = System.getenv("DOCKER_HOST");
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