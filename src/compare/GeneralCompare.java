package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hwang-yunho on 2019-07-17
 * @project effective-java-3e
 */
public class GeneralCompare {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("김철수");
        names.add("황윤호");
        names.add("이정수");
        names.add("박정민");


        Collections.sort(names);
        for(String name : names) {
            System.out.println(name);
        }
    }
}
