package chapter2.item5.di;

import chapter2.item5.Lexicon;

public class SpellChecker {

    private final Lexicon dictionary;
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }
    //    public static boolean isValid(String word) { ...}

//    철자를 체크하는 SpellChekcer가 있다고 생각해보자.
//    맞춤법 검사기는 사전에 의존하는데, 사용하는 자원에 따라 동작이 달라지는 클래스에서
//    싱글톤이나 정적 클래스 방식은 적합하지 않다.

//    여러 자원을 지원해야 하거나, 클라이언트가 원하는 인스턴스를 사용해야 할 경우
//    필요한 자원을 생성자에 넘겨주어 전달하도록 하자!!
//    자원을 직접 명시하지 않고, 의존 객체 주입을 설정함으로써 간단하게 코드를 향상 시켜 줄 수 있다.
}
