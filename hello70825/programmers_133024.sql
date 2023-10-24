/**

상반기에 판매된 아이스크림의 맛 조회
[정렬] 총주문량 기준 DESC , 출하 번호 기준 ASC

**/

SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC
