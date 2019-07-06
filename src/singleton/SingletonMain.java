package singleton;

public class SingletonMain {
    public static void main(String[] args) {
        // Singleton의 생성자는 private이기 때문에 new로 인스턴스 생성 불가
        //Singleton singleton1 = new Singleton();

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        System.out.println(singleton1.getInput());
        System.out.println(singleton2.getInput());
        System.out.println(singleton3.getInput());

        singleton1.setInput("singleton1!!");
        System.out.println(singleton1.getInput());
        System.out.println(singleton2.getInput());
        System.out.println(singleton3.getInput());

    }
}
