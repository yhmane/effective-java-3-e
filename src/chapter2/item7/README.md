## Item7
### 다 쓴 객체 참조를 해제하라

* Java의 경우 C, C++ 처럼 메모리를 직접 관리하지 않음
* C, C++의 경우 개발자가 메모리를 직접 할당하고 해제하지만 Java는 가비지 컬렉터가 존재한다
* 하지만, 아예 신경을 안 써도 되는 것은 아니다.
* 가비지 컬렉션의 소멸 대상이 되지 않는다면 메모리 누수가 일어나고, 대용량 처리의 경우 OOM을 일으킬 수도 있다

#### 가비지 컬렉션의 소멸 대상
> 직접할당 해제
```java
public class Stack {
    // 문제가 있는 메서드
    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        return elements[--size];
    }
    
    // 직접할당 해제 하는 메서드
    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] == null; // 다 쓴 참조 해제
        return result;
    }
}
```
* 다슨 객체의 참조 변수에 null을 할당해준다.
* heap 메모리에서 존재하는 객체는 어떠한 참조도 가지지 않기에 가비지 컬렉션의 소멸 대상이 된다.
* 클래스 내에서 메모리 관리하는 객체라면 써야 겠지만(Stack), 일반적으론 아래의 방법(Scope를 통한 자동 할당 해제)가 좋

> Scope를 통한 자동 할당 해제
* 지역 변수의 범위를 최소화 해준다 (item57), 지역변수의 선언된 변수들은 함수 return과 함께 정리된다.
* 메서드를 작게 유지하고, 한가지 기능에 초점을 맞춘다면 지역 변수 범위 최소화의 도움이 된다.

#### 메모리 누수를 일으키는 주범
* 첫번째 케이스처럼 클래스내에서 인스턴스에 대한 참조를 관리하는 객체 -> unreachable (null) 상태로 만들어 GC의 대상으로 만들어 준다
* Map과 같은 캐시 -> WeakHashMap() 사용을 고려해 보자
* 리스너 또는 콜백 -> 클라이언트가 콜백을 등록하고 명확히 해지하지 않는다면 콜백은 계속 쌓여 간다. 이럴 경우 약한 참조로 설정하여 주면 GC가 즉시 수거해 간다.


