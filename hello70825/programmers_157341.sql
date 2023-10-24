/**

자동차 ID 리스트
[조건] 자동차 종류가 세단
[조건] 10월에 대여를 시작한 기록이 있는 자동차
[조건] 중복이 없어야함
[정렬] 자동차 ID 기준 내림차순

**/

SELECT DISTINCT(CRCC.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR AS CRCC 
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CRCR 
    ON CRCC.CAR_ID = CRCR.CAR_ID
WHERE CRCC.CAR_TYPE = '세단' AND CRCR.START_DATE >= '2022-10-01'
ORDER BY CRCC.CAR_ID DESC