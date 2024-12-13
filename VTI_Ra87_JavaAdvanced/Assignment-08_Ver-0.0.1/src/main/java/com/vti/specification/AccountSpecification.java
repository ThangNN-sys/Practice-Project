package com.vti.specification;

import com.vti.entity.Account;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AccountSpecification {

    public static Specification<Account> buildWhere(String nameSearch) {
        if (StringUtils.isEmpty(nameSearch)) {
            return null;
        }
        nameSearch = nameSearch.trim();
        CustomSpecification name = new CustomSpecification("username", nameSearch);
        return Specification.where(name);
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {

    @NonNull
    private final String fieldName;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            @NonNull Root<Account> root,
            CriteriaQuery<?> query,
            @NonNull CriteriaBuilder criteriaBuilder){
        if (fieldName.equalsIgnoreCase("username")) {
            return criteriaBuilder.like(root.get("username"), // username is username field of Account class
                    "%" + value.toString() + "%");
        }
        return null;
    }
}