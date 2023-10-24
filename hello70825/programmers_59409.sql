/**

동물의 아이디, 이름, 중성화 여부
[조건] 중성화된 동물은 SEX_UPON_INTAKE에 'Neutered' 또는 'Spayed' 단어가 
들어있음
[조건] 중성화가 되어 있으면 O, 아니면 X로 표시
[정렬] 아이디 기준 ASC

**/

SELECT ANIMAL_ID, NAME, IF(SEX_UPON_INTAKE LIKE '%Neutered%' OR 
SEX_UPON_INTAKE LIKE '%Spayed%', 'O', 'X')
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC
