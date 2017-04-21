package eu.nyerel.searchtable.api.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class Sort implements Serializable {

    private List<Order> orders;

    public Sort() {
    }

    public Sort(List<Order> orders) {
        this.orders = orders;
    }

    public static Sort from(Order order) {
        return new Sort(Collections.singletonList(order));
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
