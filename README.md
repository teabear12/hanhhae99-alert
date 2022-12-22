# alert!

## 👨‍👨‍👧‍👦팀원

- [서보성](https://github.com/teabear12)
- [서재석](https://github.com/suhjaesuk)
- [오호진](https://github.com/1Tsw0rd)
- [황보석](https://github.com/seok6086)

## ✅주요 기능

1. **일정등록, 조회, 수정, 삭제**
2. **시간 별 일정 색상 이미지 변화**

## Stack
### BE
<img src="https://img.shields.io/badge/Swagger-green?style=for-the-badge&logo=Swagger&logoColor=white"/> <img alt="Java" src ="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F.svg?&style=for-the-badge&logo=Spring Boot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F.svg?&style=for-the-badge&logo=Spring Security&logoColor=white"> <img src="https://img.shields.io/badge/JWT-000000.svg?&style=for-the-badge&logo=JSON Web Tokens&logoColor=white"> <img src="https://img.shields.io/badge/Gradle-02303A.svg?&style=for-the-badge&logo=Gradle&logoColor=white">

### Deploy
<img src="https://img.shields.io/badge/Amazon EC2-yellow?style=for-the-badge&logo=Amazon EC2&logoColor=white">

## Trouble Shooting
**CORS preflight OPTIONS 메소드 문제**
- SpringSecurity에서 허용한 Method : GET, POST, PATCH, DELETE
- 최초 Front와 Back 간 통신 중 이러한 SpringSecurity 정책 문제로 Front의 요청을 Block처리함
- 확인 결과 CORS preflight 통신 시, 사전에 OPTIONS 메소드 사용하여 예비통신이 먼저 진행되는데,
  OPTIONS 메소드를 SpringSecurity 정책으로 차단하여 발생한 문제였음
-  스프링 시큐리티에서 OPTIONS 메서드 허용하여 해결

-  preflight 발생 조건
  1) GET, HEAD, POST 요청이 아닌 경우
  2) Content-Type이 다음 3가지가 아닌 경우
  - application/x-www-form-urlencoded
  - multipart/form-data
  - text/plain
  **application/json 사용하는 경우 발생

