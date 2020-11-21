package chapter2.item3;

public enum Item3Enum {
    INSTANCE("윤호", 10);

    private String name;
    private int age;

    private Item3Enum(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
