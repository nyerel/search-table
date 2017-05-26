package eu.nyerel.searchtable.core.repository;

import eu.nyerel.searchtable.api.model.filter.LogicalOperator;
import eu.nyerel.searchtable.api.model.filter.expression.AttributeExpression;
import eu.nyerel.searchtable.api.model.filter.expression.Expression;
import eu.nyerel.searchtable.api.model.filter.expression.ExpressionList;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class SpecificationCreator {

    public <T> Specification<T> create(Expression expression) {
        return (root, query, cb) -> {
            QueryScopedCreator<T> creator = new QueryScopedCreator<>(query, cb);
            return creator.createPredicate(expression, root);
        };
    }

    private static class QueryScopedCreator<T> {

        private final CriteriaQuery query;
        private final CriteriaBuilder cb;

        public QueryScopedCreator(CriteriaQuery query, CriteriaBuilder cb) {
            this.query = query;
            this.cb = cb;
        }

        private Predicate createPredicate(Expression expression, Root<T> root) {
            if (expression instanceof ExpressionList) {
                return createFromList((ExpressionList) expression, root);
            } else if (expression instanceof AttributeExpression) {
                return createFromAttribute((AttributeExpression) expression, root);
            } else {
                throw new UnsupportedOperationException("Unknown expression type: " + expression.getClass().getName());
            }
        }

        private Predicate createFromAttribute(AttributeExpression expression, Root<T> root) {
            Path<Object> attributePath = root.get(expression.getProperty());
            switch (expression.getOperator()) {
                case EQUALS:
                    return cb.equal(attributePath, expression.getValue());
                case NOT_EQUALS:
                    return cb.notEqual(attributePath, expression.getValue());
                case IN:
                    return cb.in
                case NOT_IN:
                    return cb.not(cb.in())
                case GREATER:
                    return cb.greaterThan(attributePath, expression.getValue());
                case GREATER_OR_EQUAL:
                    return cb.
                case LESS:
                    return cb.
                case LESS_OR_EQUAL:
                    return cb.

            }
        }

        private Predicate createFromList(ExpressionList list, Root<T> root) {
            List<Predicate> predicates = new ArrayList<>();
            for (Expression ex : list.getExpressions()) {
                predicates.add(createPredicate(ex, root));
            }
            Predicate[] predicateArray = predicates.toArray(new Predicate[predicates.size()]);
            if (list.getLogicalOperator().equals(LogicalOperator.AND)) {
                return cb.and(predicateArray);
            } else {
                return cb.or(predicateArray);
            }
        }

    }



}
