/**

동물의 아이디, 이름, 성별, 중성화 여부 조회 SQL문
[조건] 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty
[정렬] 동물의 아이디 기준 ASC

**/

SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME = 'Lucy' OR Name = 'Ella' OR Name = 'Pickle' OR Name = 'Rogan' OR Name = 'Sabrina' OR Name = 'Mitty'
ORDER BY ANIMAL_ID ASC
