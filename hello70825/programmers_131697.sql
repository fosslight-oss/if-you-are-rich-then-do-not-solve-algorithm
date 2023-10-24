/**
판매중인 상품중에 가장 높은 판매가를 출력하는 SQL문을 작성
이때 컬럼명은 MAX_PRICE로 설정
**/

SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT
