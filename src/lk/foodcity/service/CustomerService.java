/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.foodcity.service;

import java.sql.SQLException;
import lk.foodcity.dto.CustomerDto;
import lk.foodcity.repository.CustomerRepository;

/**
 *
 * @author Hp
 */
public class CustomerService {
    
    private CustomerRepository customerRepository;
    
    public int addCustomer(CustomerDto custmerDto) {
        customerRepository = new CustomerRepository();
        try {
            return customerRepository.addCustomer(custmerDto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public CustomerDto getCustomerByNic(String nic) {
        customerRepository = new CustomerRepository();
        try {
            return customerRepository.getCustomerByNic(nic);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int updateCustomerByNic(CustomerDto customerDto) {
        customerRepository = new CustomerRepository();
        try {
            return customerRepository.updateCustomerByNic(customerDto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
