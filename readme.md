📗 스프링 Spring
================
<hr />

> 스프링 이유와 원리에 대해 공부하고 객체지향 설계를 고민하는 개발자가 되자!

<br />

#### 주문 도메인 전체 그림

<img width="862" alt="전체그림" src="https://user-images.githubusercontent.com/68539040/182746470-66caf457-020c-442c-b3d8-a15235c0d56b.png">

- ```#1``` 문제점 발견
    + DIP 위반. ```OrderServiceImpl```은 ```DiscountPolicy``` 인터페이스에도 의존하고, 구현 클래스인  ```FixDiscountPolicy```
      와 ```RateDiscountPolicy```에도 의존하고 있다.
    + OCP 위반. ```FixDiscountPolicy```를 ```RateDiscountPolicy```로 변경하는 순간 ```OrderServiceImpl```코드도 변경해야 한다. 지금 코드는 기능을
      확장하면 클라이언트 코드에 영향을 주기 때문에 OCP를 위반함. <br />
      이에 대한 해결책으로 인터페이스에만 의존하게 하기 위해, ```OrderServiceImpl``` 코드를 아래처럼 바꿨다.  <br />
      (기존) ``` private final DiscountPolicy discountPolicy = new RateDiscountPolicy();``` <br />
      (변경) ``` private DiscountPolicy discountPolicy; ``` <br />
      하지만 이렇게 하면 당연히 객체 생성된게 없기 때문에.. nullpointerexception이 터진다. AppConfig 클래스를 생성해 DI(의존관계 주입)로 해결한다. <br /><br />
- 해결
    + ```AppConfig```를 통해 코드 분리.(관심사 분리) ```AppConfig```가 구현클래스를 선택해 주게 되었기 때문에, 이제 ```OrderServiceImpl```는 기능을 실행하는 책임만
      지면 된다.


- ```#2``` 문제점 발견

- 해결
    + ```AppConfig```에 중복 됐었던```new MemberRepository()```부분을 분리. 이제 다른 구현체로 변경할 때 이 부분만 변경하면 된다. 또 역할과 구현 클래스가 한 눈에 들어와서
      애플리케이션 전체 구성을 파악하기 좋아졌다.