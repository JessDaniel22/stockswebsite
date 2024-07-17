package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TopCompaniesService;

@RestController
public class TopCompaniesController {

    private final TopCompaniesService topCompaniesService;

    @Autowired
    public TopCompaniesController(TopCompaniesService topCompaniesService) {
        this.topCompaniesService = topCompaniesService;
    }

    @GetMapping("/top-companies")
    public List<String> getTopCompanies() {
        return topCompaniesService.getTopCompanies();
    }
}
