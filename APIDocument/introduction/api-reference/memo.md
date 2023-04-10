---
description: 메모장 관련 API
---

# Memo

## 메모장 메모 저장

{% swagger method="post" path="/board" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="메모장에 메모 작성 후 저장" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="title" type="String" %}
메모의 제목 작성
{% endswagger-parameter %}

{% swagger-parameter in="body" name="content" type="String" %}
저장할 메모 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="메모 저장 완료" %}
```
Create Success
```
{% endswagger-response %}
{% endswagger %}





## 메모장 메모 수정

{% swagger method="post" path="/modifyBoard" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="메모장에 메모 수정" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="long" %}
수정할 메모 아이디 작성
{% endswagger-parameter %}

{% swagger-parameter in="body" name="title" type="String" %}
수정할 제목 내용
{% endswagger-parameter %}

{% swagger-parameter in="body" name="content" type="String" %}
수정할 메모 내용
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="메모 수정 완료" %}
```
Modify Success
```
{% endswagger-response %}
{% endswagger %}





## 메모장 메모 삭제

{% swagger method="post" path="/boardDelete" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="메모장에 메모 삭제" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="id" type="long" %}
삭제할 메모의 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="메모 저장 완료" %}
```
Delete Success
```
{% endswagger-response %}
{% endswagger %}
