package com.mssc.services.impl;

import com.mssc.services.CustomerService;
import com.mssc.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Joe Buck")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        // todo implement
        log.warn("UpdateCustomer by id:{}", uuid);
    }

    @Override
    public void deleteCustomerById(UUID uuid) {
        //todo implement
        log.warn("Delete customer by Id: {}", uuid);
    }
}
