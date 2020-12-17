package view;

import common.Guide;
import common.InvalidException;
import domain.MainScreen;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Table inputTableNumber() {
        Guide.print("주문할 테이블을 선택하세요.");
        String tableInput = scanner.nextLine().trim();
        return checkTableNumber(tableInput);
    }

    private static Table checkTableNumber(String tableInput) {
        try {
            int table = Integer.parseInt(tableInput);
            return TableRepository.findTable(table);
        } catch (NumberFormatException n) {
            throw new InvalidException("숫자를 입력해 주세요.");
        }
    }

    public static int inputMainScreen() {
        while (true) {
            try {
                Guide.print("할 일을 선택하세요.");
                String selection = scanner.nextLine().trim();
                return checkMainScreen(selection);
            } catch (InvalidException invalidException) {
                System.out.println(invalidException.getMessage());
            }
        }
    }

    private static int checkMainScreen(String selectionInput) {
        try {
            int selection = Integer.parseInt(selectionInput);
            checkValidListSelection(selection);
            return selection;
        } catch (NumberFormatException n) {
            throw new InvalidException("숫자를 입력해 주세요.");
        }
    }

    private static void checkValidListSelection(int selection) {
        if (Arrays.stream(MainScreen.values())
            .noneMatch(value -> Objects.equals(value.getKey(), selection))) {
            throw new InvalidException("해당 범위 내의 입력을 해주세요.");
        }
    }

    public static Menu inputMenu(){
        OutputView.printMenuSelectGuide();
        return MenuRepository.findMenu(scanner.nextLine().trim());
    }

    public static int inputMenuAmount() {
        OutputView.printMenuAmountGuide();
        String amountInput = scanner.nextLine().trim();
        return checkAmountNumber(amountInput);
    }

    private static int checkAmountNumber(String amountInput) {
        try {
            int amount = Integer.parseInt(amountInput);
            checkValidAmount(amount);
            return amount;
        } catch (NumberFormatException n) {
            throw new InvalidException("숫자를 입력해 주세요.");
        }
    }

    private static void checkValidAmount(int amount) {
        if(amount <0 || amount >99){
            throw new InvalidException("1~99 사이의 값을 입력해 주세요");
        }
    }
}
