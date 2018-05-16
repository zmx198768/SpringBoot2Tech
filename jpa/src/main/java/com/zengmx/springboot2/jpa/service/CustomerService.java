package com.zengmx.springboot2.jpa.service;

import com.zengmx.springboot2.jpa.bean.Customer;
import com.zengmx.springboot2.jpa.dao.CustomerDao;
import com.zengmx.springboot2.jpa.dao.spec.CustomerSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/11  14:26
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public String add(String username, String birthday) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setBirthday(birthday);
        customer = customerDao.save(customer);
        return customer.getUnid();
    }

    public boolean update(String username, String birthday) {
        Customer customer = customerDao.findByUsername(username);
        customer.setBirthday(birthday);
        customerDao.save(customer);
        return true;
    }

    public long count() {
        return customerDao.count();
    }

    public List<Customer> findByBirthday(String beginday, String endday) {
        return customerDao.findAll(CustomerSpec.findByBirthday(beginday, endday));
    }

    public List<Customer> findAllByUsernameLike(String username) {
        username = "%" + username + "%";
        return customerDao.findAllByUsernameLike(username);
    }

    public boolean deleteByIds(String ids) {
        List<Customer> customers = new ArrayList<Customer>();
        String splitChar = ",";
        for(String id : ids.split(splitChar)) {
            //JDK8特性，返回Optional值，强制要求必须对于是否为空进行校验
            Optional<Customer> opCustomer = customerDao.findById(id);
            if (opCustomer.isPresent()) {
                customers.add(opCustomer.get());
            }
        }
        customerDao.deleteInBatch(customers);
        return true;
    }

    public void updateEnableById(boolean enable, String id) {
        customerDao.updateEnableById(enable, id);
    }
}
