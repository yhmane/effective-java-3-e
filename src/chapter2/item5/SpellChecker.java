package chapter2.item5;

import java.util.List;
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;
    private SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    public boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) { return null; }
}
