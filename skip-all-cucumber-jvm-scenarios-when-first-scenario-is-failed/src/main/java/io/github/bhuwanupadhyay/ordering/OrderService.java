package io.github.bhuwanupadhyay.ordering;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class OrderService {

    static List<Order> orders = new LinkedList<Order>();

    public void addOrder(String customerId) {
        orders.add(new Order(UUID.randomUUID().toString(), customerId));
    }

    public int totalOrders() {
        return orders.size();
    }

}
