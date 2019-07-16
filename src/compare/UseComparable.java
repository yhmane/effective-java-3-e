package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hwang-yunho on 2019-07-17
 * @project effective-java-3e
 */
public class UseComparable {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("황윤호", "asd@naver.com", 29));
        users.add(new User("박정수", "zx12@gmail.com", 32));
        users.add(new User("이정민", "oo@naver.com", 25));
        users.add(new User("김진구", "asd@hanmail.net", 39));

        Collections.sort(users);

        for(User user:users) {
            System.out.println(user);
        }
    }
}

class User implements Comparable<User> {
    private String name;
    private String email;
    private int age;

    public User(String name, String email, int age) {
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
    public int compareTo(User u) {
        return this.name.compareTo(u.getName());
    }

    @Override
    public String toString() {
        return this.getName() + ", " +this.getEmail() + ", " + this.getAge();
    }
}
