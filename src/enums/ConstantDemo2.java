package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */
public class ConstantDemo2 {
    private static final int APPLE  = 1;
    private static final int PEACH  = 2;
    private static final int BANANA = 3;
    public static void main(String[] args) {
        /**
         * 기존 주석으로 처리하여 생겼던 문제들을
         * 상수로 처리하여 해결하였다.
         *
         * 하지만, 기업을 상수로 처리할 일이 생긴다면??
         * 과일의 APPLE과 기업의 APPLE이 충돌 하여 컴파일이 되지 않을 것이다.
         */

        int type = APPLE;
        switch (type) {
            case APPLE:
                System.out.println(57);
                break;
            case PEACH:
                System.out.println(34);
                break;
            case BANANA:
                System.out.println(93);
                break;
        }
    }
}
