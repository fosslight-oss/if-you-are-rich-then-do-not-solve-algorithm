/**

생물 종, 이름, 성별, 중성화 여부
[조건] 이름이 NULL인 동물은 'No name'으로 표기
[정렬] 아이디 기준 ASC

**/

SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC
