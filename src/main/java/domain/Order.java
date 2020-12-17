package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int amount;

    public Order(Table table, Menu menu, int amount){
        this.table = table;
        this.menu = menu;
        this.amount = amount;
    }

}
