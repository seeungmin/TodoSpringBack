# TodoSpringBack

## Todo 컨트롤러 예시

### 기존 프로젝트 API 형태

![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/29b39f7f-7bfb-4afc-a4e3-525d32319e7a)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/f6dafd22-acbf-4274-9e0e-e8f36f3231b0)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/cd1bda6a-2e3f-4114-926a-eb8ce5ce8a85)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/582dbd6d-b228-4ec8-a7a8-e810fef63a2e)


> 기존에는 GET, POST 매핑을 통해서 CRUD를 구현함
> 
> 호출하는 주소에서 각각의 API가 어떤 행동을 하는지 나타냄 
***




### 리팩토링 후 프로젝트 API 형태
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/a3d7de94-11e1-4cb0-9d53-717f180da7e5)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/53a9e104-b7c4-483d-98d3-ed501d9ff293)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/0a08455c-4a97-41d0-bc31-f4e789569d44)
![image](https://github.com/seeungmin/TodoSpringBack/assets/91742262/d6949f7b-b73a-46f7-bee0-5055bda873c3)

> 리팩토링 후 GET, POST, PUT, DELETE 매핑을 통해서 CRUD를 구현함
> 
> 호출하는 주소는 컨트롤러의 이름과 같음
> 
> 협업시 API가 겹치는 일이 발생하지 않음
