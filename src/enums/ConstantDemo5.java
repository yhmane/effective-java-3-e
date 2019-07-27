package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */

enum Fruit {
    APPLE, PEACH, BANANA
}

enum Company {
    GOOGLE, APPLE, ORACLE
}

public class ConstantDemo5 {
    public static void main(String[] args) {
        /**
         * enum을 사용함으로써
         *
         * 1. 코드가 단순해짐
         * 2. 인스턴스 생성과 상속을 방지
         * 3. 구현의 의도가 열거임을 알 수 있음
         */
        Fruit type = Fruit.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal");
                break;
            case PEACH:
                System.out.println(34+" kcal");
                break;
            case BANANA:
                System.out.println(93+" kcal");
                break;
        }
    }
}
