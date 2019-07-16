package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hwang-yunho on 2019-07-17
 * @project effective-java-3e
 */
public class UseComparator {
    public static void main(String[] args) {

        List<Employee> employee  = new ArrayList<>();
        employee.add(new Employee("황윤호", "asd@naver.com", 29));
        employee.add(new Employee("박정수", "zx12@gmail.com", 32));
        employee.add(new Employee("이정민", "oo@naver.com", 25));
        employee.add(new Employee("김진구", "asd@hanmail.net", 39));

        Collections.sort(employee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for(Employee empl:employee) {
            System.out.println(empl);
        }
    }
}

class Employee  {
    private String name;
    private String email;
    private int age;

    public Employee(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getName() + ", " +this.getEmail() + ", " + this.getAge();
    }
}
