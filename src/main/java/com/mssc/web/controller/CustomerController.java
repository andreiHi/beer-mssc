package com.mssc.web.controller;

import com.mssc.services.CustomerService;
import com.mssc.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto>getCustomer(@PathVariable("customerId")UUID id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto>createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        HttpHeaders headers = new HttpHeaders();
        final CustomerDto customer = customerService.createCustomer(customerDto);
        headers.add("Location", customer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerById(@PathVariable("customerId") UUID uuid, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(uuid, customerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") UUID uuid) {
        customerService.deleteCustomerById(uuid);
    }
}
