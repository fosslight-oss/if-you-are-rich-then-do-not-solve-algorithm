/**

동물 이름 중 두 번 이상 쓰인 이름, 이름이 쓰인 횟수 조회
[조건] 이름이 없으면 집계에서 제외
[정렬] 이름 기준 ASC

**/

SELECT NAME, COUNT(NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME ASC
