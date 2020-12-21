## Item5
### 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

클래스는 다른 클래스의 자원에 의존하는 경우가 많습니다.
> 정적 유틸리티 클래스
```java
public class SpellChecker {
    private static final Lexicon dictionary = ...;
    private SpellChecker() {}
    public static boolean isValid(String word) { ... }
    public static List<String> suggestions(String typo) { ... }
}

SpellChecker.isValid("word")
```

> 싱글턴 클래스
```java
public class SpellChecker {
    private final Lexicon dictionary = ...;
    private SpellChecker(...) {}
    public static SpellChecker INSTANCE = new SpellChecker(...);
    public static boolean isValid(String word) { ... }
    public static List<String> suggestions(String typo) { ... }
}

SpellChecker.INSTANCE.isValidisValid("word")
```

- 사전은 영어, 국어, 한자 등이 있지만 두 클래스 모두 하나의 명시된 자원(사전)에다만 의존합니다.
- 확장이 힘들고, 테스트하기 쉽지 않은 코드입니다.

> 의존 객체 주입
```java
public class SpellChecker {
    private final Lexicon dictionary;
    private SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    public boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) { return null; }
}
```
- 클래스가 내부적으로 하나 이상의 자원에 의존한다면 확장성있는 코드를 짜야 합니다
- 생성자에 필요한 자원을 넘겨주는 방식을 고려해 보면 좋습니다 (팩토리 method pattern)