package enums;

/**
 * @author hwang-yunho on 2019-07-28
 * @project effective-java-3e
 */
public class ConstantDemo {

    public static void main(String[] args) {
        /**
         * 1. 사과
         * 2. 복숭아
         * 3. 바나나
         *
         * 사과 복숭아 바나나가 있다고 하자.
         * 각 값에 숫자를 매핑하였는데, 이것을 주석으로 남겼다고 하면??
         *
         * 누군가 필요 없다고 생각하여 주석으로 남기게 되면 히스토리를 알 수 없게 된다.
         * 따라서, 상수를 처리하기 위해 final을 쓰게 되었는데 ...
         */

        int type = 1;
        switch (type) {
            case 1:
                System.out.println(57);
                break;
            case 2:
                System.out.println(34);
                break;
            case 3:
                System.out.println(93);
                break;
        }
    }
}

