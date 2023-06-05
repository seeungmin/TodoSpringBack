---
description: 캐시 메모 관련 API
---

# CashBoard

## 전체 캐시 메모 조회

{% swagger method="get" path="/cashBoards/user/{userId}" baseUrl="http://ec2-18-183-36-88.ap-northeast-1.compute.amazonaws.com:8000" summary="메모 preview 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="uesrId" type="String" %}
로그인한 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 유니크한 아이디,
    "userId": 회원 아이디,
    "title": 제목,
    "cashData": 메모 내용,
    "uploadTime": 메모를 저장한 시간
    "modifyTime": 메모를 수정한 시간
}
```
{% endswagger-response %}
{% endswagger %}
