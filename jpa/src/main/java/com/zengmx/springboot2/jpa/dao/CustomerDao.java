package com.zengmx.springboot2.jpa.dao;

import com.zengmx.springboot2.jpa.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/10  14:42
 */
public interface CustomerDao extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {

    /**
     * 找相似姓名人员
     * @param username
     * @return
     */
    List<Customer> findAllByUsernameLike(String username);

    Customer findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update t_customer set enable=:enable where unid=:id", nativeQuery = true)
    /**
     * modifying 只能返回void或者int，不能返回其他值
     */
    void updateEnableById(@Param("enable") Boolean enable, @Param("id") String id);
}
