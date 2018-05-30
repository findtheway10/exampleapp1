# android-pattern-playground

- 본 레포지토리는 노리 한국제품 문제화면의 축소판 프로젝트입니다. 실제 프로덕트를 개발하다 보면 특정코드에 새로운 패턴/기술/패러다임을 적용해 리펙토링을 진행해야 할 때가 있습니다.
- 이런 새로운 패턴들을 배포 제품 코드라인에 바로 적용하기에는 부담이 있습니다.
- 이럴 때 본 프로젝트에 먼저 빠르게 적용해보고 장/단점을 알아볼 수 있습니다.
- 혹은 프로그래머가 생각한 특정 패턴이 있다면 이 패턴이 정말 유효할지를 본 프로젝트에 먼저 적용해 테스트해 볼 수 있습니다.
- 각각의 패턴의 장/단점을 기술하고 서로 공유해 훗날의 리팩토링에서 어떤 패턴을 적용할지 결정할 수 있습니다.

## 브랜치 구성

- [master](https://github.com/Knowre-Dev/android-pattern-playground)
  - POP(proof of pattern) 을 하기 위한 기초 구성이 되어있는 브랜치 입니다.
  - 본 브랜치로부터 checkout 해서 살을 붙여 다른 패턴들의 브랜치들을 생성하면 됩니다.
  - 기본적인 프로젝트 내용들이 구성되었습니다.
      - Rx, Dagger2, Kotlin 가 dependency 에 기본적으로 추가돼 있습니다.
      - 빈 액티비티 클래스들이 만들어져 있습니다.
      - 각 액티비티의 layout 은 constraint latout 으로 이미 구성되어 있습니다.
      - Server module 에 imperative server(Server.java) 와 rx server(Rxjava.kt) 가 각각 구현되어 있습니다. 
          - 원하는 패턴따라 사용하시면 됩니다.
          - 이 서버는 실제 서버가 아닌 서버를 흉내 내는 simulated 서버 입니다.
  - 현재 본 브랜치의 UX 중 기억해야할만 한 것은 아래와 같습니다.
      - 문제화면에 메인문제만 존재하고 스탭은 존재하지 않습니다만 추후 이도 추가 될 것입니다.

- [mvvm-rxjava-1](https://github.com/Knowre-Dev/android-pattern-playground/tree/mvvm-rxjava-1)
  - Rxjava 를 활용한 MVVM 패턴 POP의 첫번째 브랜치입니다.
  - 현재 문제화면 (기본) 만 구성해두었습니다.
  
