## Item9
### try-finally보다는 try-with-resources를 사용하라

* InputStream, OutputStream, Connection 등 close()를 직접 호출해 닫아줘야 하는 자원이 많이 있습니다.
* 성능문제로 이어질 수 있기 때문에 finalizer를 이용하지만 믿을만하지 못합니다.
```java
// 나쁘진 않다
static String firstLineOfFile(String path) throws IOException {
    BuffreredReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();
    } finally {
        br.close();
    }
}

// 두번쨰의 경우 꽤 난해한 코드가 작성되었다
static void copy(String src, String dist) throws IOException {
    InputStream in = new FileInputStream(src);
    try {
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }   
        } finally {
            out.close();
        }   
    } finally {
        in.close();
    }
}
```
* 예외는 try블록과 finally 블록 모두에서 발생할 수 있습니다.
* 물리적인 문제가 발생한다면 try, finally에서 모두 예외가 발생합니다.
* 하지만, 이런 경우 두번째 예외가 첫번째 문제를 삼켜서 실제 시스템에서 버그 추적이 어려워 질 수도 있습니다.

### 대안점은?
* 자바7이 투척한 try-with-resource를 사용
* AutoCloseable를 구현하고 close method()를 사용할 것

```java
static String firstLineOfFile(String path) throws IOException {
    try (BuffreredReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    } 
}

static void copy(String src, String dist) throws IOException {
    try (InputStream in = new FileInputStream(src);
         OutputStream out = new FileOutputStream(dst)) {
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) >= 0) {
            out.write(buf, 0, n);
        }
    }
}

static String firstLineOfFile(String path) throws IOException {
    try (BuffreredReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    } catch (IOException e) {
        return defaultVal;
    }
}
```
* try-with-resources를 이용하면 첫번째 예외부터 추적이 가능해집니다.
* 뿐만아니라 스택 추적 영역으로 예외를 추적할 수 있습니다.

### 결론
* try-finally보다는 try-with-resources를 사용하는 것이 좋습니다.
* 코드는 짧고 명확해지고, 예외 정보도 더욱 유용합니다.