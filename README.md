``` java
- 가상 스레드 사용
spring:
  threads:
    virtual:
      enabled: true

 
-  Java 21에 새롭게 추가된 Virtual Thread
기존 Java의 스레드는 Platform Thread였으며, Java 21부터 새로운 유형의 스레드 Virtual Thread가 추가되었다. 
OS thread는 다른 Virtual Thread를 실행시킬 수 있다. (실제 OS thread 수보다 더 많은 thread를 실행)

```
