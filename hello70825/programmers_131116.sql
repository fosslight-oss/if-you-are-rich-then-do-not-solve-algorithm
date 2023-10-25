/**

식품의 분류, 가격, 이름을 조회
[조건] 가격이 제일 비싼 식품
[조건] 식품분류 = 과자, 국, 김치, 식용유
[정렬] 식품 가격 기준 DESC

(CATEGORY, MAX_PRICE) IN (서브쿼리)?

**/

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) 
    IN (SELECT CATEGORY, MAX(PRICE)
        FROM FOOD_PRODUCT
        GROUP BY CATEGORY)
    AND CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC
