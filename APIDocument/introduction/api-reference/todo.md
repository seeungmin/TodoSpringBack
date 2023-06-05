---
description: 할 일 관련 API
---

# Todo

## 할 일 전체조회

{% swagger method="get" path="/todos/user/{userId}" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="uesrId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 고유한 할 일 아이디,
    "user_Id": 회원 아이디,
    "content": 할 일내용,
    "uploadTime": 할 일을 업로드한 시간
    "modifyTime": 할 일을 수정한 시간
}
```
{% endswagger-response %}
{% endswagger %}





## 할 일 저장

{% swagger method="post" path="/todo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 작성 후 저장" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-parameter in="body" name="content" type="String" %}
저정할 할 일 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="할 일 저장 완료" %}
```
{
    "id": 고유한 할 일 아이디,
    "message": "Create Success"
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="할 일 저장 실패" %}
```
{
    "id": null,
    "message": "Create Fail"
}
```
{% endswagger-response %}
{% endswagger %}





## 할 일 내용 수정

{% swagger method="put" path="/todo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 수정" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
수정할 할 일 아이디 입력
{% endswagger-parameter %}

{% swagger-parameter in="body" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-parameter in="body" name="content" type="String" %}
수정할 할 일 내용 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="수정 완료" %}
```
{
    "id": 고유한 할 일 아이디,
    "message": "Modify Success"
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="수정 실패" %}
```
{
    "id": null,
    "message": "Modify Fail"
}
```
{% endswagger-response %}
{% endswagger %}





## 할 일 삭제

{% swagger method="delete" path="/todo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
삭제할 할 일 아이디 입력
{% endswagger-parameter %}

{% swagger-parameter in="body" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="할 일 삭제 완료" %}
```
{
    "id": 고유한 할 일 아이디,
    "message": "Delete Success"
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="할 일 삭제 실패" %}
```
{
    "id": null,
    "message": "Delete Fail"
}
```
{% endswagger-response %}
{% endswagger %}







