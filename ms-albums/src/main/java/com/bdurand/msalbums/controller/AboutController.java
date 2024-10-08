package com.bdurand.msalbums.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
public class AboutController{

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    public String about() {
        return "Application Version: " + appVersion;
    }
}