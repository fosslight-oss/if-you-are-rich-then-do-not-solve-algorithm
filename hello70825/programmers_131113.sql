/**

주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL
[조건] 5월 1일 기준
[조건] 출고 여부는 5월 1일까지 출고완료로, 이후는 출고 대기로, 미정은 출고미정으로 출력
[정렬] 주문 ID 기준 ASC

출고완료, 출고대기, 출고미정(NULL)로 구분 가능
**/

SELECT 
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
    IF(DATE_FORMAT(OUT_DATE, '%Y-%m-%d') <= '2022-05-01', 
       '출고완료', 
        IF(DATE_FORMAT(OUT_DATE, '%Y-%m-%d') IS NOT NULL, '출고대기', '출고미정')) AS '출고여부'
FROM FOOD_ORDER

