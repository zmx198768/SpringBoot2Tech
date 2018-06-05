package com.zengmx.springboot2.datajpa.service;

import com.zengmx.springboot2.datajpa.bean.Customer;
import com.zengmx.springboot2.datajpa.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  13:43
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer add(String username, String birthday) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setBirthday(birthday);
        return customerRepository.save(customer);
    }

    public void add(List<Customer> customerList) {
        customerRepository.saveAll(customerList);
    }
}
