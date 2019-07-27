package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */
public class ConstantDemo3 {

    // fruit
    private final static int FRUIT_APPLE = 1;
    private final static int FRUIT_PEACH = 2;
    private final static int FRUIT_BANANA = 3;

    // company
    private final static int COMPANY_GOOGLE = 1;
    private final static int COMPANY_APPLE = 2;
    private final static int COMPANY_ORACLE = 3;
    public static void main(String[] args) {
        /**
         * 과일의 APPLE과 기업의 APPLE이 충돌 하여 컴파일이 되지 않을 것이다.
         *
         * 기업의 문제를 접두사를 이용하여 해결하였다.
         * 접두사를 이용하여 이름이 중복될 경우를 해결하였지만,
         * 상수가 많아지고 지저분 해졌다.
         */

        int type = FRUIT_APPLE;
        switch (type) {
            case FRUIT_APPLE:
                System.out.println(57);
                break;
            case FRUIT_PEACH:
                System.out.println(34);
                break;
            case FRUIT_BANANA:
                System.out.println(93);
                break;
        }
    }
}
