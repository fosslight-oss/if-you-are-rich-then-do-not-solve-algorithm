/**

아이스크림 성분 타입, 아이스크립 총주문량 조회하는 SQL
[조건] 총주문량은 TOTAL_ORDER로 네이밍
[정렬] 총주문량 기준 ASC

**/

SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS F JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC
