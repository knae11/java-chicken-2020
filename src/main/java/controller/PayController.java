package controller;

import domain.Menu;
import domain.Table;
import java.util.List;

public class PayController {
    final List<Table> tables;
    final List<Menu> menus;
    public PayController(List<Table> tables, List<Menu> menus){
        this.tables = tables;
        this.menus = menus;
    }
    public void run(){

    }
}
