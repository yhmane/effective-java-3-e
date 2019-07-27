package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */

interface FRUIT {
    int APPLE  = 1;
    int PEACH  = 2;
    int BANANA = 3;
}

interface COMPANY {
    int GOOGLE = 1;
    int APPLE  = 2;
    int ORACLE = 3;
}
public class ConstantDemo4 {

    public static void main(String[] args) {

        /**
         * 인터페이스를 사용함으로써 네임스페이스가 복잡해지는 것을 방지하였다.
         *
         * 하지만, 만약 type = COMPANY.GOOGLE이 들어온다면?
         * 문제 없이 실행될 것이다.
         * 비교대상이 아니지만, 컴파일러는 위의 논리적 오류를 잡아주지 못한다.
         */

        int type = FRUIT.APPLE;
        switch (type) {
            case FRUIT.APPLE:
                System.out.println(57);
                break;
            case FRUIT.PEACH:
                System.out.println(34);
                break;
            case FRUIT.BANANA:
                System.out.println(93);
                break;
        }
    }

}
