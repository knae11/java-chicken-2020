package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void addOrder(Table tableNumber, Menu menu, int amount) {
        orders.add(new Order(tableNumber, menu, amount));
    }


}
