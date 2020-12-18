package domain;

public enum Payment {
    CARD(1, ". 신용카드"), CASH(2, ". 현금");
    private final int key;
    private final String content;

    Payment(int key, String content) {
        this.key = key;
        this.content = content;
    }

    public int getKey() {
        return key;
    }

    public String getList() {
        return key + content;
    }
}
