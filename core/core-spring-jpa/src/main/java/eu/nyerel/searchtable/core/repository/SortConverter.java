package eu.nyerel.searchtable.core.repository;

import eu.nyerel.searchtable.api.model.Direction;
import eu.nyerel.searchtable.api.model.Order;
import eu.nyerel.searchtable.api.model.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
@Component
public class SortConverter {

    public org.springframework.data.domain.Sort convert(Sort source) {
        if (source == null) {
            return null;
        } else {
            return new org.springframework.data.domain.Sort(convertOrders(source.getOrders()));
        }
    }

    private List<org.springframework.data.domain.Sort.Order> convertOrders(List<Order> orders) {
        return orders.stream().map(this::convertOrder).collect(Collectors.toList());
    }

    private org.springframework.data.domain.Sort.Order convertOrder(Order order) {
        org.springframework.data.domain.Sort.Direction direction = convertDirection(order.getDirection());
        return new org.springframework.data.domain.Sort.Order(direction, order.getProperty());
    }

    private org.springframework.data.domain.Sort.Direction convertDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null!");
        }
        return org.springframework.data.domain.Sort.Direction.fromStringOrNull(direction.name());
    }

}
