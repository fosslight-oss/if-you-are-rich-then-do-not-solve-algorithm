/**

월, 자동차 ID, 월별 자동차 ID별 총 대여 횟수(RECORDS)를 조회
[조건] 2022-08 ~ 2022-10 총 대여 횟수가 5회 이상
[조건] 특정 월의 대여가 0이면 결과에서 제외
[정렬] 월 기준 ASC, 자동차 ID 기준 DESC

**/

SELECT 
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(HISTORY_ID) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE 
    START_DATE >= '2022-08-01' 
    AND START_DATE < '2022-11-01'
    AND CAR_ID IN (
        SELECT 
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE 
            START_DATE >= '2022-08-01' 
            AND START_DATE < '2022-11-01'
        GROUP BY CAR_ID
        HAVING COUNT(HISTORY_ID) >= 5
        )
GROUP BY MONTH, CAR_ID
HAVING RECORDS > 0
ORDER BY MONTH ASC, CAR_ID DESC
