## Item3
### private 생성자나 열거 타입으로 싱글턴임을 보증하라

#### 싱글턴(Singleton)
> 싱글턴이란?
* 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말합니다. (Application내에서 단 1개의 인스턴스만 생성할 수 있는 클래스)
* 한번의 객체 생성으로 재사용이 가능하기 때문에 메모리 낭비를 방지할 수 있습니다.
* 싱글톤으로 생성된 객체는 전역성을 띄기에 다른 객체와 공유가 용이합니다.

> 싱글턴의 단점
* 싱글턴의 역할을 복잡하게 부여할 경우, 객체간의 결합도가 높아지는 문제가 발생살 수 있습니다.
* 멀티 쓰레드 환경에서 동기화 처리 문제가 있습니다.
* 인터페이스를 구현한 싱글턴 객체가 아니라면 mock 객체를 만들 수 없기에 테스트가 어렵습니다.

#### 싱글턴의 구현
> 필드 방식의 싱글턴
```java
public class Item3 {
    public static final Item3 INSTANCE = new Item3();
    private Item3() {}
}

public class Item3Main {
    public static void main(String[] args) {
        Item3 item3 = Item3.INSTANCE;
    }
}
```
> 정적 팩터리 메서드 방식의 싱글턴
```java
public class Item3 {
    private static final Item3 INSTANCE = new Item3();
    public static Item3 getInstance() {
        return INSTANCE;
    }
    private Item3() {}
}


public class Item3Main {
    public static void main(String[] args) {
        Item3 item3 = Item3.getInstance();
    }
}
```
> Enum 방식의 싱글턴
```java
public enum Item3Enum {
    INSTANCE("윤호", 10);

    private String name;
    private int age;

    private Item3Enum(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```


#### 정리
* 싱글턴을 만드는 위와 같이 다양히 존재합니다.
* 리플렉션을 통한 예외가 존재하기에 생성자에 검증작업을 추가하여 새로운 인스턴스를 생성하지 못하도록 막아야 합니다.
```java
if( INSTANCE != null) {
    throw new RuntimeException("Can't create Constructor");
}
```
* 싱글 클래스를 직렬화한 후 역직렬화할 때 새로운 인스턴스를 만들어서 반환합니다. 다음과 같이 싱글턴임을 보장해야 합니다.
```java
private Object readResolve(){
    // '진짜' 객체를 반환하고, 가짜 객체는 가비지 컬렉터에 맡깁니다.
    return INSTANCE;
}
```