/**

자동차 리스트 출력
[조건] 네비게이션 옵션이 포함
[정렬] 자동차 ID 기준 내림차순 정렬

**/

SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC
