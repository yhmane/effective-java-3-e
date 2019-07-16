package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hwang-yunho on 2019-07-17
 * @project effective-java-3e
 */
public class GeneralCompareError {

    public static void main(String args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("황윤호", 29));
        students.add(new Student("박정수", 40));
        students.add(new Student("김진구", 35));
        students.add(new Student("이정민", 21));

//         어느것을 기준으로 정렬하지 모르기 떄문에 에러가 발생
//        Collections.sort(students);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}