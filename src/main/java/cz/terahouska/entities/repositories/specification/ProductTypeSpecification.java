package cz.terahouska.entities.repositories.specification;

import cz.terahouska.entities.ProductEntity;
import cz.terahouska.entities.ProductEntity_;
import cz.terahouska.entities.filters.ProductTypeFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class ProductTypeSpecification implements Specification<ProductEntity> {
    private final ProductTypeFilter filter;
    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filter.getType() != null) {
            return criteriaBuilder.equal(root.get(ProductEntity_.TYPE), filter.getType());
        }
        return null;
    }
}
