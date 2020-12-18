package common;

public class Guide {
    private static final String GUIDE_PREFIX = "## ";

    private Guide() {

    }

    public static void print(String message) {
        System.out.println(GUIDE_PREFIX + message);
    }

}
