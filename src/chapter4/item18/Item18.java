package chapter4.item18;

import java.util.HashSet;
import java.util.List;

public class Item18 {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s.getAddCount());

        InstrumentedSet<String> s2 = new InstrumentedSet<>(new HashSet<String>());
        s2.addAll(List.of("틱", "탁탁", "펑"));
        System.out.println(s2.getAddCount());
    }
}
