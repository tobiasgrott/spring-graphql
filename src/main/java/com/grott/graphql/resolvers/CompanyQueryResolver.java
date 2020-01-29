package com.grott.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.grott.graphql.model.Company;
import com.grott.graphql.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CompanyService companyService;

    public Company company(String name){
        return companyService.getCompanyByName(name);
    }
}