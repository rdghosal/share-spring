package com.finance.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
class AppContoller {

    @GetMapping
    public String testRoute() {
        return "Good!";
    }
}
