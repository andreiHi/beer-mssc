package com.mssc.services;

import com.mssc.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID id);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID uuid, CustomerDto customerDto);

    void deleteCustomerById(UUID uuid);
}
