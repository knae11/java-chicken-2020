package view;

import common.Guide;
import domain.MainScreen;
import domain.Menu;
import domain.Payment;
import domain.Table;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMainScreen(){
        Guide.print("선택 화면");
        Arrays.stream(MainScreen.values()).map(list -> list.getList()).forEach(System.out::println);
    }
    public static void printPayments(){
        Guide.print("결제 목록");
        Arrays.stream(Payment.values()).map(list -> list.getList()).forEach(System.out::println);
    }

    public static void printTables(final List<Table> tables) {
        Guide.print("테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMenuSelectGuide(){
        Guide.print("메뉴를 선택해 주세요. 1가지만 선택할 수 있습니다.");
    }

    public static void printMenuAmountGuide(){
        Guide.print("해당 메뉴의 수량을 입력해 주세요.");
    }
}
