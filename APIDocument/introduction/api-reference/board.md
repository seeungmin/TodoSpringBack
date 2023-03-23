# Board

## 메모 preview 조회

{% swagger method="get" path="/previewCashBoard" baseUrl="" summary="메모 preview 전체를 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="조회 성공시 json으로 데이터 반환" %}
```
{
    "id": 유니크한 아이디,
    "cashData": 메모 내용,
    "uploadTime": 메모를 저장한 시간
}
```
{% endswagger-response %}
{% endswagger %}

## 메모 detail 조회

{% swagger method="get" path="/detailBoard" baseUrl="" summary="preview 선택시 메모의 상세내용 조회" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="header" name="id" type="Long" %}
완료한 일로 옮길 할 일 아이디
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="조회 성공시 id 반" %}
```
{
    "id": 유니크한 아이디,
    "cashData": 메모 내용,
    "uploadTime": 메모를 저장한 시간
}
```
{% endswagger-response %}
{% endswagger %}
