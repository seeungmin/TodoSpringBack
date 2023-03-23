---
description: 할 일 관련 API
---

# Todo

## 할 일 저장

{% swagger method="post" path="/todo" baseUrl="" summary="할 일 작성 후 저장" %}
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

{% swagger method="post" path="/finishTodo" baseUrl="" summary="다 한일 저장" %}
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

{% swagger method="post" path="/modifyTodo" baseUrl="" summary="할 일 수정" %}
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

{% swagger method="post" path="/todoDelete" baseUrl="" summary="할 일 삭제" %}
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

{% swagger method="post" path="/finishTodoDelete" baseUrl="" summary="다 한일 삭제" %}
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





