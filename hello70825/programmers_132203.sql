/**

[진료과가 CS, GS인 의사의 이름, 의사 ID, 진료과, 고용일자]
[정렬] 고용일자 DESC, 이름 ASC
[조건] HIRE_YMD 출력이 살짝 다름
**/

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d")
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC
