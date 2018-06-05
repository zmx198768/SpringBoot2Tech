package com.zengmx.springboot2.datajpa.dao.spec;

import com.zengmx.springboot2.datajpa.bean.FdsPeople;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Company:互撸娃大战铁茎肛.avi
 *
 * @author <a href="mailto:8574157@qq.com">zengmx</a>
 * @date 2018/6/1  16:03
 */
public class FdsPeopleSpec {

    /**
     * 将所有的查询条件封装到map中，对于map进行迭代操作
     * @param conditions
     * @return
     */
    public static Specification<FdsPeople> findFdsPeopleSpec(Map<String, Object> conditions) {
        return new Specification<FdsPeople>() {
            @Override
            public Predicate toPredicate(Root<FdsPeople> root, CriteriaQuery<?> q, CriteriaBuilder cb) {

                List<Predicate> predicateList = new ArrayList<>();

                //equal示例
                if (!StringUtils.isEmpty(conditions.get("unid"))) {
                    predicateList.add(cb.equal(root.get("unid"), conditions.get("unid")));
                }
                if (!StringUtils.isEmpty(conditions.get("deptunid"))) {
                    predicateList.add(cb.equal(root.get("deptunid"), conditions.get("deptunid")));
                }
                //like实例
                if (!StringUtils.isEmpty(conditions.get("name"))) {
                    predicateList.add(cb.like(root.get("name"), "%" + conditions.get("unid") + "%"));
                }
                if (!StringUtils.isEmpty(conditions.get("executorid"))) {
                    predicateList.add(cb.like(root.get("executorid"), "%" + conditions.get("executorid") + "%"));
                }
                //ge,le示例
                if (!StringUtils.isEmpty(conditions.get("startBirthday"))) {
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("birthday"), (String)conditions.get("startBirthday")));
                }
                if (!StringUtils.isEmpty(conditions.get("endBirthday"))) {
                    predicateList.add(cb.lessThanOrEqualTo(root.get("birthday"), (String)conditions.get("endBirthday")));
                }

                //in示例
                if (conditions.get("roleList") != null) {
                    List<String> roleList = (List<String>)conditions.get("roleList");
                    if (roleList.size() > 0) {
                        predicateList.add(root.get("role").in(roleList));
                    }
                }
                if (conditions.get("areacodeList") != null) {
                    List<String> areacodeList = (List<String>)conditions.get("areacodeList");
                    if (areacodeList.size() > 0) {
                        predicateList.add(root.get("areacode").in(areacodeList));
                    }
                }

                //or条件示例
                if (!StringUtils.isEmpty(conditions.get("checkOnly"))) {
                    Predicate predicateExecutoridNotNull = cb.isNotNull(root.get("executorid"));
                    Predicate predicateRoleLeader = root.get("role").in("抽查人员", "执法人员");
                    Predicate predicateCheckOnly = cb.or(predicateExecutoridNotNull, predicateRoleLeader);
                    predicateList.add(predicateCheckOnly);
                }

                //排序，通过orderList传输
                if (conditions.get("orderMap") != null) {
                    List<Order> orderList = new ArrayList<>();
                    LinkedHashMap<String, Boolean> orderMap = (LinkedHashMap<String, Boolean>)conditions.get("orderMap");
                    for(Map.Entry<String, Boolean> orderEntry : orderMap.entrySet()) {
                        Order order = new OrderImpl(root.get(orderEntry.getKey()), orderEntry.getValue());
                        orderList.add(order);
                    }

                    q.orderBy(orderList);
                }




                //最终将查询条件拼好然后return
                Predicate[] predicates = new Predicate[predicateList.size()];
                return cb.and(predicateList.toArray(predicates));
            }
        };
    }
}
