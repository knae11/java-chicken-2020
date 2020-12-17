package controller;

import common.InvalidException;
import domain.Menu;
import domain.OrderRepository;
import domain.Table;
import java.util.List;
import view.InputView;
import view.OutputView;

public class PayController {
    final List<Table> tables;
    final List<Menu> menus;
    public PayController(List<Table> tables, List<Menu> menus){
        this.tables = tables;
        this.menus = menus;
    }
    public void run(){
        while (true) {
            try {
                getPayment();
                return;
            } catch (InvalidException invalidException) {
                System.out.println(invalidException.getMessage());
            }
        }
    }

    private void getPayment() {
        OutputView.printTables(tables);
        final Table tableNumber = InputView.inputTableNumber();
        OutputView.printPayments();
        int payment = InputView.inputPayment();
        double moneyToPay = OrderRepository.pay(tableNumber,payment);
        System.out.println(moneyToPay);
    }
}
