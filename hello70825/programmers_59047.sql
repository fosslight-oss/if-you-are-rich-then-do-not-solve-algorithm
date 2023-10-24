/**

개의 아이디와 이름 조회
[조건] 개
[조건] 이름에 el이 들어감
[조건] 이름 대소문자 구분하지 않음
[정렬] 이름 기준 ASC

**/

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' AND (NAME LIKE '%el%' OR NAME LIKE '%EL%')
ORDER BY NAME ASC
