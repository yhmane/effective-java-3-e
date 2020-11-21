package chapter2.item3;

public class Item3 {
    // 필드 방식
    // public static final Item3 INSTANCE = new Item3();

    // 메서드 방식
    private static final Item3 INSTANCE = new Item3();
    public static Item3 getInstance() {
        return INSTANCE;
    }
    private Item3() {}
}
