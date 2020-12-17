package controller;

import domain.MainScreen;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.OutputView;

public class ChickenController {
    final List<Table> tables = TableRepository.tables();
    final List<Menu> menus = MenuRepository.menus();
    final OrderController orderController;
    final PayController payController;

    public ChickenController() {
        orderController = new OrderController(tables, menus);
        payController = new PayController(tables, menus);
    }

    public void run() {
        while (true) {
            OutputView.printMainScreen();
            int selection = InputView.inputMainScreen();
            if (selection == MainScreen.EXIT.getKey()) {
                return;
            }
            runChickenService(selection);
        }

    }

    private void runChickenService(int selection) {
        if (selection == MainScreen.ORDER.getKey()) {
            orderController.run();
        }
        if (selection == MainScreen.PAY.getKey()) {
            payController.run();
        }
    }

}
