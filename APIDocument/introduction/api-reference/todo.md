---
description: 할 일 관련 API
---

# Todo

## 할 일 저장

{% swagger method="post" path="/todo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 작성 후 저장" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="content" type="String" %}
저정할 할 일 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="할 일 저장 완료" %}
```
{
    "id": 유니크한 할 일 아이디
    "message": "Create Success"
}
```
{% endswagger-response %}
{% endswagger %}





## 완료한 일 저장

{% swagger method="post" path="/finishTodo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="다 한일 저장" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
다 한일로 옮길 한 일 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="다 한일 저장 완료" %}
```
{
    "id": 유니크한 할 일 아이디
    "message": "Create Success"
}
```
{% endswagger-response %}
{% endswagger %}





## 할 일 내용 수정

{% swagger method="post" path="/modifyTodo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 수정" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
수정할 할 일 아이디 입력
{% endswagger-parameter %}

{% swagger-parameter in="body" name="content" type="String" %}
수정할 할 일 내용 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="수정 완료" %}
```
Modify Success
```
{% endswagger-response %}
{% endswagger %}





## 할 일 삭제

{% swagger method="post" path="/todoDelete" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
삭제할 할 일 아이디 입력
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="할 일 삭제 완료" %}
```
Delete Success
```
{% endswagger-response %}
{% endswagger %}





## 완료한 일 삭제

{% swagger method="post" path="/finishTodoDelete" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="다 한일 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
삭제할 다 한일 아이디 입력
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="할 일 삭제 완료" %}
```
Delete Success
```
{% endswagger-response %}
{% endswagger %}





## 할 일 전체조회

{% swagger method="get" path="/previewTodo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="할 일 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 유니크한 아이디,
    "member_Id": 회원 아이디,
    "cashData": 할 일내용,
    "uploadTime": 할 일을 업로드한 시간
    "modifyTime": 할 일을 수정한 시간
}
```
{% endswagger-response %}
{% endswagger %}





## 다 한 일 전체조회

{% swagger method="get" path="/previewFinishTodo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000/previewFinishTodo" summary="다 한 일 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 유니크한 아이디,
    "member_Id": 회원 아이디,
    "cashData": 할 일내용,
    "uploadTime": 할 일을 업로드한 시간
    "completionTime": 할 일을 완료한시간
}
```
{% endswagger-response %}
{% endswagger %}
