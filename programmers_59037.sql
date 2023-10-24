/**
젋은 동물의 아이디와 이름을 조회하는 SQL문 작성하기
[젊은의 기준] INTAKE_CONDITION이 Aged가 아닌 경우
[정렬] ID 기준 오름차순

---
COUNT(*) = 100개
Aged인 데이터 7개

**/

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != "Aged"
ORDER BY ANIMAL_ID ASC
