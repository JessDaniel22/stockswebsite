package com.example.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TopCompaniesService {
    private final List<String> topCompanies = new CopyOnWriteArrayList<>();

    public TopCompaniesService() {
        updateTopCompanies();
    }

    @Scheduled(fixedRate = 5000)
    public void updateTopCompanies() {
        // Logic to update top companies (e.g., fetch from an external API)
        // For demo purposes, let's just shuffle the list
        topCompanies.clear();
        topCompanies.addAll(List.of("Company A", "Company B", "Company C", "Company D", "Company E"));
        java.util.Collections.shuffle(topCompanies);
    }

    public List<String> getTopCompanies() {
        return topCompanies;
    }
}
