package com.zengmx.springboot2.datajpa.service;

import com.zengmx.springboot2.datajpa.bean.FdsPeople;
import com.zengmx.springboot2.datajpa.dao.FdsPeopleRepository;
import com.zengmx.springboot2.datajpa.dao.spec.FdsPeopleSpec;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.*;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  14:19
 */
@Service
public class FdsPeopleService {

    @Autowired
    FdsPeopleRepository repository;

    public FdsPeople add(FdsPeople fdsPeople) {
        return repository.save(fdsPeople);
    }

    public FdsPeople getById(String id) {
        return repository.getOne(id);
    }

    public List<FdsPeople> findByDeptunid(String deptunid) {
        return repository.findAllByDeptunid(deptunid);
    }

    public List<FdsPeople> findBydeptunidSort(String deptunid) {
        return repository.findAllByDeptunidOrderByName(deptunid);
    }

    public Page<FdsPeople> findByDeptunidPage(String deptunid, Pageable pageable){
        return repository.findAllByDeptunid(deptunid, pageable);
    }

    public Page<FdsPeople> findByDeptunidPageSort(String deptunid, Pageable pageable){
        return repository.findAllByDeptunidOrderByName(deptunid, pageable);
    }

    public Page<FdsPeople> findByBirthday(String startBirthday, String endBirthday, String checkOnly, Pageable pageable) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("startBirthday", startBirthday);
        conditions.put("endBirthday", endBirthday);
        conditions.put("checkOnly", checkOnly);

        Map<String, Boolean> orderMap = new LinkedHashMap<>();
        orderMap.put("name", false);
        conditions.put("orderMap", orderMap);
        return repository.findAll(FdsPeopleSpec.findFdsPeopleSpec(conditions), pageable);
    }
}
