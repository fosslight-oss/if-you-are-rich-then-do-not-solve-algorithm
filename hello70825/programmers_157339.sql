/**

자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 
[조건] 자동차 종류가 '세단', 'SUV'
[조건] 2022-11-01 ~ 2022-11-30 동안 대여 가능
[조건] 대여 금액이 50만원 <= price < 200만원 AS FEE
[정렬] 대여금액 기준 DESC, 자동차종류 기준 ASC, 자동차 ID 기준 DESC

(해결) 1. 11월 동안 대여가능한지 확인하는 로직
(해결) 2. 대여 금액은 30 * DAILY_FEE로 가능함 + (세단은 10% 할인, SUV는 8% 할인) -> SELECT에서 IF절로 가능
**/


SELECT DISTINCT CAR_ID, CAR_TYPE, FLOOR(DAILY_FEE * 30 * REAL_PRICE / 100) AS FEE
FROM (
        SELECT
            CRCC.CAR_ID,
            CRCC.CAR_TYPE,
            CRCC.DAILY_FEE,
            DATEDIFF(CRCRH.END_DATE, CRCRH.START_DATE) + 1,
            100 - CASE
                WHEN CRCC.CAR_TYPE = 'SUV'
                THEN (
                        SELECT DISCOUNT_RATE
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                        WHERE CAR_TYPE = 'SUV' AND DURATION_TYPE = '30일 이상'
                )
                WHEN CRCC.CAR_TYPE = '세단'
                THEN (
                        SELECT DISCOUNT_RATE
                        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                        WHERE CAR_TYPE = '세단' AND DURATION_TYPE = '30일 이상'
                )
                ELSE 0
            END AS REAL_PRICE
        FROM
            CAR_RENTAL_COMPANY_CAR AS CRCC
            JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CRCRH
            ON CRCC.CAR_ID = CRCRH.CAR_ID
            JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS CRCDP
            ON CRCC.CAR_TYPE = CRCDP.CAR_TYPE
        WHERE (CRCC.CAR_TYPE = 'SUV' OR CRCC.CAR_TYPE = '세단')
                AND CRCC.CAR_ID NOT IN (
                            SELECT CAR_ID
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            WHERE '2022-11' BETWEEN
                                                DATE_FORMAT(START_DATE, '%Y-%m')
                                                AND
                                                DATE_FORMAT(END_DATE, '%Y-%m')
                )
) AS A
WHERE FLOOR(DAILY_FEE * 30 * REAL_PRICE / 100) >= 500000
        AND FLOOR(DAILY_FEE * 30 * REAL_PRICE / 100) < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC
