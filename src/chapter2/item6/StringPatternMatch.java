package chapter2.item6;

import java.util.regex.Pattern;

/**
 * @author hwang-yunho on 2019-07-14
 * @project effective-java-3e
 */
public class StringPatternMatch {

    // 불필요한 객체 생성을 피해야 하는데 특히,
    // 값비싼 객체는 재사용하여 성능을 향상 시키는 것이 좋다.
    // Pattern의 경우 정규표현식에 해당하는 유한 상태 머신을 만들기 때문에 인스턴스 생성 비용이 비싸다.
    // 따라서, 불변 객체를 미리 캐싱하여 사용하는 것이 좋다.
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static void main(String[] args) {
        String msg = "Pattern Constructor";

        long start = System.currentTimeMillis(); //시작하는 시점 계산
        for(int i=0; i<10000; i++) {
            msg.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        }
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "long 실행 시간 : " + ( end - start )/1000.0 + "초");


        long startCahcing = System.currentTimeMillis(); //시작하는 시점 계산
        for(int i=0; i<10000; i++) {
            ROMAN.matcher(msg).matches();
        }
        long endCaching = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "long 실행 시간 : " + ( endCaching - startCahcing )/1000.0 + "초");

    }
}
