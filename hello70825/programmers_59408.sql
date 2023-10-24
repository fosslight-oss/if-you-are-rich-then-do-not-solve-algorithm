/**

동물의 이름이 몇 개인지 조회
[조건] 이름이 NULL이면 집계하지 않음
[조건] 중복 이름은 1개라고 생각함

**/

SELECT COUNT(DISTINCT(NAME))
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
