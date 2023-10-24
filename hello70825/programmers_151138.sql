/**

대여기록 출력하는 SQL문
[조건] 대여 시작일이 2022년 9월
[조건] 위 조건에서 대여 기간이 30일 이상이면 '장기 대여', 아니라면 '단기 
대여'로 RENT_TYPE을 추가
[정렬] 대여 기록 ID 기준 DESC

DATEDIFF + 1을 해야함 = 당일날 대여해서 반납하면 0일 사용이 아닌, 하루 사용한 
것이므로
**/

SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, 
DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE, IF(DATEDIFF(END_DATE, 
START_DATE) + 1 >= 30, '장기 대여', '단기 대여') AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= '2022-09-01' AND START_DATE < '2022-10-01'
ORDER BY HISTORY_ID DESC
