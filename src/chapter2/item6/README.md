## Item6
### 불필요한 객체 생성을 피하라

> 자주 사용되는 객체의 재사용
```java
public class Item6 {
    public static void main(String[] args) {
        // 1 (not recomended)
        String s1 = new String("hello");
        // 2 recomended
        String s = "hello";
        
        // 3 (not recomended)
        Boolean trueOne = new Boolean(true);
        Boolean falseOne = new Boolean(false);

        // 4 (not recomended)
        Boolean trueObject = Boolean.valueOf(true);
        Boolean falseObject = Boolean.valueOf(false);
    }
}
```
1번의 문장은 실행될 때 마다 String 인스턴스를 새로 만든다. <br>
이 문장이 반복문이나 빈번히 호출되는 메서드 안에 있다면 String 인스턴스가 반복적으로 계속 생겨난다.<br>
2번의 경우, 하나의 인스턴스를 사용한다. 또한, 같은 가상머신 안에서 똑같은 문자열 리터럴을 사용하는 모든 코드가 같은 객체를 재사용하는 것이 보장된다.<br>

3번의 경우, 매번 Boolean 생성자를 사용하는 방식이다. 추천하지 않는 방식이다.<br>
4번의 경우, 정적 팩터리 메서드(아이템1)을 이용해 불피요한 객체 생성을 피할 수 있다.

> 비용이 큰 객체의 재사용
```java
public class RomanNumerals {
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?-.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3}) (I[XV]|V?I{0,3|)$");
    }
}
 ```
이 방식의 문제점은 String.matches 메서드 이용에 있다.<br>
String.matches는 정규 표현식으로 문자열 형태를 확인하는 가장 쉬운 방법이지만, 메서드 내부에서 만드는 정규표현식용 Pattern은 한번쓰고 버려져 곧바로 가비지 컬렉션 대상이 된다<br>
또한, Pattern은 유한 상태 머신을 만들기 때문에 인스턴스 생성 비용이 높다.<br>

```java
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compole(
            "^(?-.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3}) (I[XV]|V?I{0,3|)$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
 ```
미리 Pattern을 초기화하여 재사용하는 것이 좋다. 이렇게 사용하면 코드의 가독성도 높아지고 더 빠른 성능을 보인다.

> 의도치 않은 Auto boxing
```java
private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
    }
    return sum;
}
```
이 코드는 정상적으로 수행된다. 하지만, 자세히 보면 문제점이 보인다.<br>
sum의 경우 Long, i의 경우 long type이다. i가 sum에 더해질 때마다 Wrapper 클래스로 Auto 박시이 일어난다.<br>
단순히, sum을 long으로 선언하기만 해도 성능은 향상된다.