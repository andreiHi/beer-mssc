package com.mssc.web.mapper;

import com.mssc.domain.Customer;
import com.mssc.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customerDto);
}
