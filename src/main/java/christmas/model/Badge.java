package christmas.model;

public enum Badge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타"),
    NOTHING(0, "없음");

    private final int minAmount;
    private final String name;

    Badge(int minAmount, String name) {
        this.minAmount = minAmount;
        this.name = name;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public String getName() {
        return name;
    }
}
