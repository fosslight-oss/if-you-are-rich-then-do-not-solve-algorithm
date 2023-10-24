/**

자동차 종류 별로 몇 대인지 출력하는 SQL문
[조건] [통풍시트, 열선시트, 가죽시트] 중 하나 이상을 가지고 있어야한다
[조건] 자동차 수에 대한 컬럼명은 CARS로 지정
[정렬] 자동차 종류 기준 ASC

**/

SELECT CAR_TYPE, COUNT(CAR_TYPE)
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE ASC
