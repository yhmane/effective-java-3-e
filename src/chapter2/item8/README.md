## Item8
### finalizer와 cleaner 사용을 피하라

* Java에서는 두 가지 객체 소멸자를 제공합니다.
* finalizer(Java8)는 예측할 수 없고 상황에 따라 위험할 수 있어 일반적으로 불필요합니다.
* cleaner(Java9)는 finalizer보다는 덜 위험하지만, 여전히 예측할 수 없고, 느리고 불필요합니다.
* 수행시점 뿐만 아닐나 수행 여부조차 보장하지 않기 때문에 분산 시스템 환경에서는 사용해서는 안됩니다.

### 대안점은?
* try-with-resource를 사용
* -> AutoCloseable를 구현하고 close method()를 사용할 것
* 해당 내용은 item9에 이어짐

### 결론
* cleaner(finalizer)는 자바8까지 안정망 역할이나 중요하지 않은 네이티브 자원 회수용으로만 사용할 것
* 사용할 경우 시점/수행 여부에 대한 불확실성을 인지하고 성능 저하에 주의해야 함
