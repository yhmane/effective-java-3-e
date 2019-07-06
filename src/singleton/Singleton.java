package singleton;

public class Singleton {

    private static Singleton singleton = null;
    private String input;

    // 객체 생성 방지
    private Singleton() {
        this.input = "singleton";
    }

    // instance 반환
    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public String getInput() {
        return this.input;
    }
    public void setInput(String input) {
        this.input = input;
    }
}