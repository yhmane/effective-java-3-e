## Item1 
### 생성자 대신 정적 팩터리 메서드를 고려하라
클래스의 인스터스를 얻는 전통적인 수단은 public 생성자를 이용하는 것입니다.<br>
하지만, 또 알아두어야 할 기법이 있으니 정적 팩토리 메서드(static factory method)를 제공할 수 있습니다.
```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;
}
```

#### 정적 팩토리 메서드가 생성자보다 좋은 장점
* 이름을 가질 수 있습니다.
```java
class Student() {
    private String name;
    private int studentNum;

    // 어떤 역할인지 명시적 표현.
    public static Student studentWithName(String name) {
         Student student = new Student();
         student.name = name;
         return student;
    }
}

public class Item1 {
    Student student2 = Student.studentWithName("홍길동");
}
```
* 호출될 때마다 인스턴스를 새로 생성하지 않아도 됩니다.
```java
class Activity {

    public static final Activity DISCOUNT_THREE_ACTIVITY = new Activity(10000.0, 3);

    private double price;
    private int activityCount;

    public static Activity setPriceWithActivity(int activityCount) {
        // 생성되어 있는 객체를 할당.
        if (activityCount == 3) {
            return DISCOUNT_THREE_ACTIVITY;
        }

        Activity activity = new Activity();
        activity.price = 20000.0;
        activity.activityCount = activityCount;
        return activity;
    }
}

public class Item1 {
    Activity activity = Activity.setPriceWithActivity(3);
}
```
* 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있습니다.<br>
생성자는 리턴값이 없지만 정적 팩토리 메소드는 반환값을 유연하게 사용할 수 있습니다.
```java
class Student {
    private String name;
    private int studentNum;
    
    public static MiddleSchool middleSchoolStudnent() {
        return new MiddleSchool();
    }
}
class MiddleSchool extends Student {}
public class Item1 {
    MiddleSchool middleSchool = Student.middleSchoolStudnent();
}
```
* 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.
```java
class Fruit {
    public static Fruit getFruit(String name) {
        if ("Apple".equals(name)) {
           return new Apple();
        } else if ("Banana".equals(name)) {
            return new Banana();
        } else {
            return new Strawberry();
        }
    }
}
class Apple extends Fruit { }
class Banana extends Fruit { }
class Strawberry extends Fruit { }
public class Item1 {
    // 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.
    Fruit fruit = Fruit.getFruit("Banana");
    System.out.println(fruit.getClass().getName());
}
```


#### 정적 팩토리 메서드의 단점
* 상속을 하려면 public, protected의 생성자가 필요합니다.<br/>
정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없습니다.
* API를 따로 제공하지 않기에 프로그래머가 찾기 어렵습니다. <br>
