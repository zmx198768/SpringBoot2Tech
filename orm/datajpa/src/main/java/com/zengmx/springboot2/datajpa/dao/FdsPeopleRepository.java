package com.zengmx.springboot2.datajpa.dao;

import com.zengmx.springboot2.datajpa.bean.FdsPeople;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  11:58
 */
public interface FdsPeopleRepository extends JpaRepository<FdsPeople, String>, JpaSpecificationExecutor<FdsPeople> {

    public List<FdsPeople> findAllByDeptunid(String deptunid);

    public List<FdsPeople> findAllByDeptunidOrderByName(String deptunid);

    public Page<FdsPeople> findAllByDeptunid(String deptunid, Pageable pageable);

    public Page<FdsPeople> findAllByDeptunidOrderByName(String deptunid, Pageable pageable);
}
