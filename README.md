# 간단한 게시판 구현

## ⚙️  디렉터리 구조

---
<img width="216" alt="스크린샷 2022-01-17 오후 8 46 18" src="https://user-images.githubusercontent.com/80299170/149775800-99c15032-0b27-49dc-8d00-36cbdcfab1ce.png">



⬅️  타임리프 레이아웃 라이브러리를 사용

**공통구성(header.html,nav.html,footer.html)**은

**layouts/layout.html**에 넣어주었다. 

새로운 html파일을 만들때 미리 제작한 layout.html을 불러오면 완성된 header,nav,footer를 사용할 수 있기에

**코드에 가독성**이 더욱 좋아진다.

## 📝  사용된 언어

---

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bfb11997-df46-484a-99ee-38deee45541e/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c893df0c-014a-4fee-bfc9-b6df79ed73be/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/40be7437-b148-4898-ab1d-d29d03ca2fd3/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/21d06781-a2d4-4d0c-b6ef-142528bff0c3/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/80e96f3b-0fa3-4685-a949-e06deaf58afe/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3a844d8d-a7b2-4204-9de6-4e6cb772d914/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7a7a675f-ab42-4aaa-8cbd-def880bb9f22/Untitled.png)

---

# 📌  진행하며 부딪힌 부분들

1. **HTML,CSS에 대한 이해부족 그리고 Thymeleaf 사용법**
    - 처음 코딩을 할 때 HTML,CSS에 대해 훑고 지나갔는데 이제와서 레이아웃도 짜고 사용할려보니 구글링하면서 고생했다.. ㅡ,,ㅡ
    - JSP나 HTML 이해도가 높으면 금방 사용할 수? 있기도 할테지만 프론트에 대한 기초지식 부족으로 진짜!! 많이 구글링했다.
2. **JPA 숙련도 부족**
    - 데이터베이스와 객체의 패러다임 불일치를 이해하고 객체끼리 연관관계를 맺는과정을 이해하는데 오래 걸렸다.
    - 단지 CRUD를 구현하는것뿐만 아니라 성능최적화까지 고민하며 작성해보았기에 더욱 시간이 오래 걸린거 같다.
    - JPQL에 대한 무지함 → **김영한님 JPA책 구매하기로한 결심..**
3. **페이징 처리**
    - JPA에서는 페이징처리를 어떻게 해야할까에 대한 고민
4. **전반적으로 Spring Boot가 아니라 Spring에 대한 지식 부족**
    - Spring boot는 더욱 편리하게 사용하기 위한 기술일 뿐, Spring 자체를 이해하고 사용했어야했다.
5. **세션을 통한 로그인 기능 구현**
    - 세션을 이해하고 구현해보는 과정에서 어려움을 느끼었다.

---

# 📎  배운점

1. JPA 영속성 컨텍스트와 변경 감지를 이해
2. 예제이지만 Setter, 생성자가 아닌 @Builder을 통해 객체를 관리
3. Spring에 전반적인 지식과 MVC패턴을 이해
4. 스프링JPA에 전반적인 지식
5. HTML,CSS,Thymeleaf을 사용하며 HTTP에 대한 지식을 쌓음
6. 쿠키와 세션 그리고 Spring Security, JWT ,OAUTH에 생태계를 알 수 있었다.

---

# 📚  아쉬웠던 점

---

1. 퀄리티 떨어지는 웹디자인
2. 자바스크립트를 사용하지 않음
3. 페이징 처리에 대한 확실한 이해
4. 검색 기능구현 한계
5. 테스트코드를 진행해보지 않은 것

---

# ❕느낀점

---

백엔드를 공부하지만 프로젝트를 하며 프론트에 투자한 시간이 더 많은거 같다..ㅋㅋㅋ 내가 프론트에 너무 무지했구나 생각이 들었다. 그리고

아직 너무나 부족한 코딩실력이라는것에 벽을 느꼇다. 이번 간단한 예제를 통해 나의 부족함을 인정하고 더욱 더 배워야겠다고 생각했다.

전체적인 틀을 잡고 이해했기에 이제는 대충 알고 넘어가는게 아니라 스스로 테스트해보며 이게 왜 돌아갔는지에 대해서 이해하려고 애써야한다.

다음에 공부할 때는 하나의 완성된 프로젝트보다는 하나의 기능을 완전히 구현해보는것에 목표를 두고해야될꺼같다. 현업에서 사용되는 것처럼 말이다.

객체지향 프로그래밍을 공부하니 공부도 객체지향적으로 하는것 같기도 하다.
