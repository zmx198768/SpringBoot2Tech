package com.zengmx.springboot2.jpa.controller;

import com.zengmx.springboot2.core.constant.ResultCodeEnum;
import com.zengmx.springboot2.core.exception.BaseException;
import com.zengmx.springboot2.jpa.bean.Customer;
import com.zengmx.springboot2.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/10  15:51
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/count")
    public long count() {
        return customerService.count();
    }

    @RequestMapping("/add")
    public String add(@RequestParam("username") String username, @RequestParam("birthday") String birthday) {
        return customerService.add(username, birthday);
    }

    @RequestMapping("/update")
    public boolean update(@RequestParam("username") String username, @RequestParam("birthday") String birthday) {
        try {
            return customerService.update(username, birthday);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("find-by-birthday")
    public List<Customer> findByBirthday(@RequestParam("beginday") String beginDay, @RequestParam("endday") String endDay) {
        return customerService.findByBirthday(beginDay, endDay);
    }

    @RequestMapping("find-by-username")
    public List<Customer> findByUsername(@RequestParam("username") String username) {
        return customerService.findAllByUsernameLike(username);
    }

    /**
     * 使用JDK8参数名发现机制，自动寻找参数名，不需要在RequestParam注解中制定对应的名称
     * @param ids
     * @return
     */
    @RequestMapping("delete-by-ids")
    public boolean deleteByIds(@RequestParam String ids) {
        try {
            return customerService.deleteByIds(ids);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("update-enable-by-id")
    public boolean updateEnableById(@RequestParam boolean enable, @RequestParam String id) {
        try {
            customerService.updateEnableById(enable, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("get-exception")
    public String getException() throws BaseException {
        throw new BaseException(ResultCodeEnum.VALICODE_TIMEOUT.getResultCode(),ResultCodeEnum.VALICODE_TIMEOUT.getMessage());
    }
}
