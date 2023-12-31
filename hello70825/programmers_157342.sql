/**

자동차 ID, 평균 대여 기간
[조건] 평균 대여 기간이 7일 이상
[조건] 평균 대여 기간은 AVERAGE_DURATION으로 네이밍
[정렬] 평균 대여 기간 기준 DESC, 자동차 ID 기준 DESC

**/

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC
