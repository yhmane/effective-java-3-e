package chapter2.item2;

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
