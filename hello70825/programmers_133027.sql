/**

아이스크림 맛
[조건] 7월 아이스크림 총 주문량 + 아이스크림 총 주문량
[조건] 상위 3개
[정렬] 조건에 있는 값 기준 DESC

같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.

GROUP BY FLAVOR
**/

SELECT FH.FLAVOR
FROM FIRST_HALF AS FH
    JOIN JULY AS J
    ON FH.FLAVOR = J.FLAVOR
GROUP BY FLAVOR
ORDER BY (FH.TOTAL_ORDER + SUM(J.TOTAL_ORDER)) DESC
LIMIT 3
