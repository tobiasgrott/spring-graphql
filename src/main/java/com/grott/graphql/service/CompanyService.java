package com.grott.graphql.service;

import com.grott.graphql.model.Company;

public interface CompanyService {
    public Company getCompanyByName(String name);
    public Company createCompany(Company comp);
}