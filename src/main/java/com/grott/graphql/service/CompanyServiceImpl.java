package com.grott.graphql.service;

import java.util.HashMap;
import java.util.Map;

import com.grott.graphql.model.Company;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private Map<String, Company> map = new HashMap<>();

    @Override
    public Company getCompanyByName(String name) {
        return name != null ? map.get(name) : null;
    }

    @Override
    public Company createCompany(Company comp) {
        if(comp != null){
            map.put(comp.getName(), comp);
        }
        return comp;
    }

}