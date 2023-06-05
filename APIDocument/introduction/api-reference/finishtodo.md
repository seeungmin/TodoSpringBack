---
description: 다 한 일 관련 API
---

# FinishTodo

## 완료한 일  전체 조회

{% swagger method="get" path="/finishTodo/list/{userId}" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="다 한 일 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 고유한 아이디,
    "member_Id": 회원 아이디,
    "content": 할 일내용,
    "uploadTime": 할 일을 업로드한 시간
    "completionTime": 할 일을 완료한시간
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

{% swagger-parameter in="body" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="다 한일 저장 완료" %}
```
{
    "id": 고유한 다한일 아이디,
    "message": "Create Success"
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="다 한일 저장 실패" %}
```
{
    "id": null,
    "message": "Create Fail"
}
```
{% endswagger-response %}
{% endswagger %}





## 완료한 일 삭제

{% swagger method="delete" path="/finishTodo" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="다 한일 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="Long" %}
삭제할 다 한일 아이디 입력
{% endswagger-parameter %}

{% swagger-parameter in="body" name="userId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="다 한 일 삭제 완료" %}
```
{
    "id" :  고유한 다한 일 아이디,
    "message": "Delete Success"
}
```
{% endswagger-response %}

{% swagger-response status="500: Internal Server Error" description="다 한 일 삭제 실패" %}
```
{
    "id": null,
    "message": "Delete Fail"
}
```
{% endswagger-response %}
{% endswagger %}

