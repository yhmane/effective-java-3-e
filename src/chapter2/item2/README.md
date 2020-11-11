## Item2
### 생성자에 매개변수가 많다면 빌더를 고려하라
* 점층적 생성자 패턴도 쓸 수 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵습니다.<br/>
```java
public class Reservation {
    private String name;
    private String phone;
    private String reservingTime;
    private String startTime;
    private String endTime;
    
    public Reservation(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Reservation(String name, String phone, String reservingTime) {
        this.name = name;
        this.phone = phone;
        this.reservingTime = reservingTime;
    }

    public Reservation(String name, String phone, String reservingTime, String startTime) {
        this.name = name;
        this.phone = phone;
        this.reservingTime = reservingTime;
        this.startTime = startTime;
    }

    public Reservation(String name, String phone, String reservingTime, String startTime, String endTime) {
        this.name = name;
        this.phone = phone;
        this.reservingTime = reservingTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
```
* 자바빈즈 패턴(setter)를 이용해 이러한 단점을 보완할 수 있지만, 객체의 일관성이 무너진 상태에 놓이게 됩니다.
```java
public static void main() {
    Reservation reservation = new Reservation();
    reservation.setName("황윤호");
    reservation.setPhone("010-1234-5678");
    reservation.setReservingTime("2020-11-01");
    reservation.setStartTime("2020-11-18");
    reservation.setEndTime("2020-11-20");
}
```
* 점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비한 빌더 패턴이 있습니다.
```java
public class Reservation {
    private String name;
    private String phone;
    private String reservingTime;
    private String startTime;
    private String endTime;
    
    public static class Builder {
        // 필수 매개변수
        private String name;
        private String phone;
        
        // 선택 매개변수
        private String reservingTime = "2020-01-01";
        private String startTime     = "2020-01-02";
        private String endTime       = "2020-01-03";
        
        public Builder(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public Builder reservingTime(String val) {
            reservingTime = val;
            return this;
        }

        public Builder startTime(String val) {
            startTime = val;
            return this;
        }

        public Builder endTime(String val) {
            endTime = val;
            return this;
        }
        
        public Reservation build() {
            return new Reservation(this);
        }
    }
    
    private Reservation(Builder builder) {
        name = builder.name;
        phone = builder.phone;
        reservingTime = builder.reservingTime;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }
}

public class Item2 {
    public static void main() {
        Reservation reservation = new Reservation
                .Builder("황윤호","010-1234-5678")
                .reservingTime("2020-11-13")
                .startTime("2020-11-20")
                .endTime("2020-11-22")
                .build();
    }
}
```


#### 정리
* 코드가 읽고 쓰기 쉬워집니다.
* 객체의 일관성을 부여할 수 있습니다.
* 빌더 패턴은 빌더를 만들어 주어야 하기 때문에 매개변수가 많지 않다면 필수는 아닙니다.
* 점층적 생성자 패턴이나 자바빈즈 패턴의 장점을 모아두었고, 생성자는 시간이 지날수록 매개변수가 늘어나니 빌더패턴을 적용하는 것이 좋습니다.