---
description: 메모장 관련 API
---

# Memo

## 메모장 메모 저장

{% swagger method="post" path="/board" baseUrl="" summary="메모장에 메모 작성 후 저장" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="content" type="String" %}
저장할 메모 작성
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="메모 저장 완료" %}
```
Create Success
```
{% endswagger-response %}
{% endswagger %}
