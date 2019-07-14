package chapter2.item6;

/**
 * @author hwang-yunho on 2019-07-14
 * @project effective-java-3e
 */
public class AutoBoxing {

    // 기본형이 아닌 박싱된 타입을 사용함으로써 Autoboxing이 이루어졌다.
    // 실행시간은 7~8배 차이가 났는데, 이런 의도치 않은 계산은 피하는게 성능면에서 좋다
    public static void main(String[] args) {

        long start = System.currentTimeMillis(); //시작하는 시점 계산
        long sum = 0l;
        for(long i =0l; i < 1000000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "long 실행 시간 : " + ( end - start )/1000.0 + "초");

        long startLong = System.currentTimeMillis(); //시작하는 시점 계산
        Long sumLong = 0l;
        for(long i =0l; i < 1000000000; i++) {
            sumLong += i;
        }
        long endLong = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "Long 실행 시간 : " + ( endLong - startLong )/1000.0 + "초");
    }
}

