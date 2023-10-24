/**

고양이와 개가 각각 몇 마리인지 조회
[조건] 고양이를 개보다 먼저 조회

**/

SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE)
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Cat' OR ANIMAL_TYPE = 'Dog'
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC
