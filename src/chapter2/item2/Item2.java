package chapter2.item2;

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
