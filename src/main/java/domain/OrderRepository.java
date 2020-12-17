package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void addOrder(Table tableNumber, Menu menu, int amount) {
        orders.add(new Order(tableNumber, menu, amount));
    }

    public static double pay(Table tableNumber, int payment) {
        List<Order> orderOfTheTable = orders.stream()
            .filter(order -> Objects.equals(order.getTable(), tableNumber))
            .collect(Collectors.toList());
        int sumOfAmount = orderOfTheTable.stream().mapToInt(order -> order.getAmount()).sum();
        int sumOfPrice = orderOfTheTable.stream().mapToInt(order -> order.getPrice()).sum();
        if(sumOfAmount>9){
            sumOfPrice -= 10000*(sumOfAmount/10);
        }
        if(payment == Payment.CASH.getKey()){
            sumOfPrice *= 0.95;
        }
        return sumOfPrice;
    }

}
