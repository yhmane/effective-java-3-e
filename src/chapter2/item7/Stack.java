package chapter2.item7;

import java.util.EmptyStackException;

/**
 * 직정할당 해제
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_STACK_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_STACK_CAPACITY];
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = elements[--size];
        elements[size] = null;  // 다 쓴 참조 해제
        return result;
    }
}
