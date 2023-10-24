/**

자동차 ID와 AVAILABILITY
[조건] 2022년 10월 16일
[조건] 대여중인 자동차는 '대여중', 아니면 '대여 가능'으로 하고 컬럼은 AVAILABILITY로 지정
[조건] 반납날짜가 2022-10-16이어도 대여중으로 표시
[정렬] 자동차 ID 기준 DESC

29 - 대여중
28 - 대여중
27 - 대여중
26 - 대여가능
25 - 
21 - 대여가능

**/

SELECT 
    CAR_ID, 
    MAX(CASE WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE
        THEN '대여중'
        ELSE '대여 가능'
        END) AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC
