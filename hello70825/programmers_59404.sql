/**
동물의 아이디, 이름, 보호 시작일을 이름 순으로 조회
단, 이름이 같으면 보호를 나중에 시작한 동물을 먼저 보여줌

---

정렬 기준
1. 이름 오름차순
2. 보호 시작일 내림차순
**/

SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC
