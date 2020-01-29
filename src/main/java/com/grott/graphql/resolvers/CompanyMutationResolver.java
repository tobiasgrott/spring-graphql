package com.grott.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.grott.graphql.model.Company;
import com.grott.graphql.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CompanyService companyService;

    public Company createCompany(Company company) {
        return companyService.createCompany(company);
    }
}