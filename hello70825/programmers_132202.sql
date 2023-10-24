/**

2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
[조건] 진료과 코드, 5월예약건수로 컬럼 이름 정하기
[정렬] 진료과 예약한 환자 수를 기준 ASC, 진료과 코드 기준 ASC

**/

SELECT MCDP_CD AS '진료과코드', COUNT(MCDP_CD) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD) ASC, MCDP_CD ASC 
