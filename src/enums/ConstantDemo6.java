package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */
enum Fruits {
    APPLE("red"),
    PEACH("pink"),
    BANANA("yellow");

    private String color;

    Fruits(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

enum Companies {
    GOOGLE,
    APPLE,
    ORACLE
}
public class ConstantDemo6 {

    public static void main(String[] args) {
        /**
         * Fruits를 호출할 떄마다 생성자가 호출되는데
         * 위와같이 변수를 선언하여
         *
         * 생성자를 호출할 때마다 값을 지정해 줄 수 있다
         */
        Fruits type = Fruits.APPLE;
        switch (type) {
            case APPLE:
                System.out.println(Fruits.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(Fruits.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(Fruits.BANANA.getColor());
                break;
        }
    }
}
