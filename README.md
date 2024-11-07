``` java
- 가상 스레드 사용
spring:
  threads:
    virtual:
      enabled: true

 
-  Java 21에 새롭게 추가된 Virtual Thread
기존 Java의 스레드는 Platform Thread였으며, Java 21부터 새로운 유형의 스레드 Virtual Thread가 추가되었다. 
OS thread는 다른 Virtual Thread를 실행시킬 수 있다. (실제 OS thread 수보다 더 많은 thread를 실행)


성능 테스트 방법
Apache JMeter 다운로드 페이지 접속

JMeter 테스트 용어
- Thread Group : 테스트에 사용될 쓰레드 개수, 쓰레드 1개당 사용자 1명
- Sampler : 사용자의 액션 (예: 로그인, 게시물 작성, 게시물 조회 등)
- Listener : 응답을 받아 리포팅, 검증, 그래프 등 다양한 처리
- Configuration : Sampler 또는 Listener가 사용할 설정 값 (쿠키, JDBC 커넥션 등)
- Assertion : 응답 확인 방법 (응답 코드, 본문 내용 비교 등)

```
