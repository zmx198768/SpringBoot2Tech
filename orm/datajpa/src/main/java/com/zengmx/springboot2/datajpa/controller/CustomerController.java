package com.zengmx.springboot2.datajpa.controller;

import com.zengmx.springboot2.datajpa.bean.Customer;
import com.zengmx.springboot2.datajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  13:46
 */
@RestController
@RequestMapping("/datajpa/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * 执行时间6317毫秒
     */
    @RequestMapping("/addThousand")
    public String addThousand() {
        long startTime = System.currentTimeMillis();
        for(int i=0;i<1000;i++) {
            service.add("batchAddThousand" + i,"2018-01-02");
        }
        long endTime = System.currentTimeMillis();
        return "cost time:" + (endTime-startTime);
    }

    /**
     * 执行时间733毫秒
     */
    @RequestMapping("/addBatchThousand")
    public String addBatchThousand() {
        List<Customer> customerList = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            Customer customer = new Customer();
            customer.setUsername("addBatchThousand" + i);
            customer.setBirthday("2018-01-03");
            customerList.add(customer);
        }
        long startTime = System.currentTimeMillis();
        service.add(customerList);
        long endTime = System.currentTimeMillis();
        return "cost time:" + (endTime-startTime);
    }



    /**
     * 执行时间4861毫秒
     */
    @RequestMapping("/addBatchTenThousand")
    public String addBatchTenThousand() {
        List<Customer> customerList = new ArrayList<>();
        for(int i=0;i<10000;i++) {
            Customer customer = new Customer();
            customer.setUsername("addBatchTenThousand" + i);
            customer.setBirthday("2018-01-04");
            customerList.add(customer);
        }
        long startTime = System.currentTimeMillis();
        service.add(customerList);
        long endTime = System.currentTimeMillis();
        return "cost time:" + (endTime-startTime);
    }

}
