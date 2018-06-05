package com.zengmx.springboot2.datajpa.dao;

import com.zengmx.springboot2.datajpa.bean.UcapDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  12:00
 */
public interface UcapDeptRepository extends JpaRepository<UcapDept, String>, JpaSpecificationExecutor<UcapDept> {
}
