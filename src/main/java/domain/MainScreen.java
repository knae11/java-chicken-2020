package domain;

public enum MainScreen {
    ORDER(1, ". 주문등록"), PAY(2, ". 결제하기"),
    EXIT(3,". 프로그램 종료");

    private final int key;
    private final String content;

    MainScreen(int key, String content) {
        this.key = key;
        this.content = content;
    }

    public int getKey(){
        return key;
    }

    public String getList(){
        return key+content;
    }
}
