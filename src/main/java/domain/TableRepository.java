package domain;

import common.InvalidException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TableRepository {
    private static List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findTable(int tableInput) {
        return tables.stream().filter(table -> table.getNumber() == tableInput).findFirst()
            .orElseThrow(() -> new InvalidException("해당 메뉴는 찾을 수 없습니다."));
    }
}
