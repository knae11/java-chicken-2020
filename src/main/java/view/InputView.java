package view;

import common.Guide;
import common.InvalidException;
import domain.MainScreen;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        Guide.print("주문할 테이블을 선택하세요.");
        return scanner.nextInt();
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
        if(!Arrays.stream(MainScreen.values()).anyMatch(value -> Objects.equals(value.getKey(), selection))){
            throw new InvalidException("해당 범위 내의 입력을 해주세요.");
        }
    }
}
