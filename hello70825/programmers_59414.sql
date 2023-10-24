/**

각 동물의 아이디, 이름, 들어온 날짜
[정렬] 아이디 기준 ASC

**/

SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS '날짜'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC
