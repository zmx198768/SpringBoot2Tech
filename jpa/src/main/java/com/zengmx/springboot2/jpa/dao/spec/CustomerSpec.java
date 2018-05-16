package com.zengmx.springboot2.jpa.dao.spec;

import com.zengmx.springboot2.jpa.bean.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Title:对于复杂查询，需要定义specification，以支持类似于参数为空的情况
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/5/11  16:19
 */
public class CustomerSpec {

    public static Specification<Customer> findByBirthday(String beginday, String endday) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (!StringUtils.isEmpty(beginday)) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(r.<String>get("birthday"), beginday));
                }

                if(!StringUtils.isEmpty(endday)) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(r.<String>get("birthday"), endday));
                }
                return predicate;
            }
        };
    }
}
