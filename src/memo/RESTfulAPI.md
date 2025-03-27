# REST API 사용법 

## 1. URL에는 동사를 쓰지 말고, 자원을 표시 

예1) ./students/1  
예2) ./get-student?student_id=1

RESTful API 에 더 맞는 것은 1번이다. 왜냐하면, 2번의 경우 자원이 아닌 다른 표현이 섞여 있기 때문이다. 동사를 사용하여 추후 개발에 혼란을 줄 수 있다. 서버에서 데이터를 요청하는 URL을 설계할때 어떤 개발자는 get 이라는 동사를 쓰고 어떤 개발자는 show-data 라고 쓴다면 행위는 같지만 표현이 중구난방 될 것이다. 

## 2. 동사는 HTTP 메서드로
HTTP 메서드는 서버에 요청을 하는 방법을 나눈 것이다. 주로 사용하는 HTTP 메서드는 POST, GET, PUT, DELETE 이다. 만들고, 읽고, 업데이트하고, 삭제하는 역할이다. 묶어서 보통 CRUD 라고 한다. 블로그에 글을 쓰는 설계를 생각해보자. 

id가 1인 블로그 글을 조회하는 API -> GET/articles/1
블로그 글을 추가하는 API -> POST/articles/1
블로그 글을 수정하는 API -> PUT/articles/1
블로그 글을 삭제하는 API -> DELETE/articles/1

