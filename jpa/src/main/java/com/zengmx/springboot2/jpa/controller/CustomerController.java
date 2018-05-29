package com.zengmx.springboot2.jpa.controller;

import com.zengmx.springboot2.core.constant.ResultCodeEnum;
import com.zengmx.springboot2.core.exception.BaseException;
import com.zengmx.springboot2.jpa.bean.Customer;
import com.zengmx.springboot2.jpa.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(description = "用户信息接口")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/count", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation("统计用户数量")
    /**
     * 通过method限定访问该方法的请求方式
     */
    public long count() {
        return customerService.count();
    }

    @RequestMapping(path = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation("增加用户信息")
    /**
     * 通过apiparam对于请求参数进行注释
     */
    public String add(@RequestParam("username") @ApiParam("用户名") String username, @RequestParam("birthday") @ApiParam("出生日期") String birthday) {
        return customerService.add(username, birthday);
    }

    @RequestMapping(path = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation("根据用户名更新用户信息")
    public boolean update(@RequestParam("username") @ApiParam(value = "用户名", required = true) String username, @RequestParam("birthday") @ApiParam(value = "出生日期", required = true) String birthday) {
        try {
            return customerService.update(username, birthday);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(path = "find-by-birthday", method = {RequestMethod.POST, RequestMethod.GET})
    public List<Customer> findByBirthday(@RequestParam("beginday") String beginDay, @RequestParam("endday") String endDay) {
        return customerService.findByBirthday(beginDay, endDay);
    }

    @RequestMapping(path = "find-by-username", method = {RequestMethod.POST, RequestMethod.GET})
    public List<Customer> findByUsername(@RequestParam("username") String username) {
        return customerService.findAllByUsernameLike(username);
    }

    /**
     * 使用JDK8参数名发现机制，自动寻找参数名，不需要在RequestParam注解中制定对应的名称
     * @param ids
     * @return
     */
    @RequestMapping(path = "delete-by-ids", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean deleteByIds(@RequestParam String ids) {
        try {
            return customerService.deleteByIds(ids);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(path = "update-enable-by-id", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean updateEnableById(@RequestParam boolean enable, @RequestParam String id) {
        try {
            customerService.updateEnableById(enable, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(path = "get-exception", method = {RequestMethod.POST, RequestMethod.GET})
    public String getException() throws BaseException {
        throw new BaseException(ResultCodeEnum.VALICODE_TIMEOUT.getResultCode(),ResultCodeEnum.VALICODE_TIMEOUT.getMessage());
    }
}
