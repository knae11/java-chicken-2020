package controller;

import common.InvalidException;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import java.util.List;
import view.InputView;
import view.OutputView;

public class OrderController {

    final List<Table> tables;
    final List<Menu> menus;

    public OrderController(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.menus = menus;
    }

    public void run() {
        while (true) {
            try {
                OutputView.printTables(tables);
                final Table tableNumber = InputView.inputTableNumber();
                OutputView.printMenus(menus);
                final Menu menuInput = InputView.inputMenu();
                return;
            } catch (InvalidException invalidException) {
                System.out.println(invalidException.getMessage());
            }
        }
    }

}
