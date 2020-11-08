package chapter2.item1;

// 이름을 가질 수 있기에 명확한 의미부여가 가능합니다.
// 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있습니다.
class Student {
    private String name;
    private int studentNum;

    public Student() { }
    public Student(String name) {
        this.name = name;
    }

    // 어떤 역할인지 명시적으로 알 수 있음
    public static Student studentWithName(String name) {
        Student student = new Student();
        student.name = name;
        return student;
    }


    // 하위 타입을 반환
    public static MiddleSchool middleSchoolStudnent() {
        return new MiddleSchool();
    }
}

// 호출될 때 마다 인스턴스를 새로 생성하지 않아도 가능합니다.
class Activity {

    public static final Activity DISCOUNT_THREE_ACTIVITY = new Activity(10000.0, 3);

    private double price;
    private int activityCount;

    public Activity() { }
    public Activity(double price, int activityCount) {
       this.price = price;
        this.activityCount = activityCount;
    }

    public static Activity setPriceWithActivity(int activityCount) {
        // 생성되어 있는 객체를 할당
        if (activityCount == 3) {
            return DISCOUNT_THREE_ACTIVITY;
        }

        Activity activity = new Activity();
        activity.price = 20000.0;
        activity.activityCount = activityCount;
        return activity;
    }
}

class MiddleSchool extends Student {}

// 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.
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
    public static void main(String[] args) {

        // 이름을 가질 수 있기에 명확한 의미부여가 가능합니다.
        Student student = Student.studentWithName("홍길동");

        // 호출될 때 마다 인스턴스를 새로 생성하지 않아도 가능합니다.
        Activity activity = Activity.setPriceWithActivity(3);

        // 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있습니다.
        MiddleSchool middleSchool = Student.middleSchoolStudnent();

        // 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있습니다.
        Fruit fruit = Fruit.getFruit("Banana");
        System.out.println(fruit.getClass().getName());
    }
}
