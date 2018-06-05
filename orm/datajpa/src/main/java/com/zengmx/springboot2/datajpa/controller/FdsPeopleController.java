package com.zengmx.springboot2.datajpa.controller;

import com.zengmx.springboot2.datajpa.bean.FdsPeople;
import com.zengmx.springboot2.datajpa.service.FdsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  14:52
 */
@RestController
@RequestMapping("/datajpa/fdspeople")
public class FdsPeopleController {

    @Autowired
    FdsPeopleService fdsPeopleService;

    @RequestMapping(path = "/find-by-deptunid", method = {RequestMethod.POST, RequestMethod.GET})
    public Page<FdsPeople> findByDeptunidPage(@RequestParam String deptunid, @RequestParam int startPage, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(startPage,pageSize);
        return fdsPeopleService.findByDeptunidPage(deptunid, pageable);
    }

    @RequestMapping(path = "/find-by-deptunid-sort", method = {RequestMethod.POST, RequestMethod.GET})
    public Page<FdsPeople> findByDeptunidPageSort(@RequestParam String deptunid, @RequestParam int startPage, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(startPage,pageSize);
        return fdsPeopleService.findByDeptunidPageSort(deptunid, pageable);
    }

    @RequestMapping(path = "/find-by-birthday", method = {RequestMethod.POST, RequestMethod.GET})
    public Page<FdsPeople> findByDeptunidPageSort(@RequestParam String startBirthday, @RequestParam String endBirthday, @RequestParam String checkOnly, @RequestParam int startPage, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(startPage,pageSize);
        return fdsPeopleService.findByBirthday(startBirthday, endBirthday, checkOnly, pageable);
    }

}
