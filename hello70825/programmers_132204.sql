/**

진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목
[조건] 2022년 4월 13일에 취소되지 않은
[조건] 흉부외과 (CS) 진료 예약 내역
[정렬] 진료예약일시 기준 ASC

SELECT (A.APNT_NO, P.PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD)
FROM (3개 JOIN)
WHERE (2022년 4월 13일에 진료를 봐야한다.) AND (흉부외과여야한다)
        
**/

SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM 
    PATIENT AS P
    JOIN APPOINTMENT AS A
    ON P.PT_NO = A.PT_NO
    JOIN DOCTOR AS D
    ON A.MDDR_ID = D.DR_ID
WHERE
    DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13'
    AND D.MCDP_CD = 'CS'
    AND A.APNT_CNCL_YN = 'N'
ORDER BY
    A.APNT_YMD ASC
