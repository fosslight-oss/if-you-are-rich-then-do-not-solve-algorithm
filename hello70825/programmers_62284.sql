/**

장바구니 아이디
[조건] 우유와 요거트를 동시에 구입한 장바구니
[정렬] 아이디 기준 ASC

1) 우유가 존재하는 장바구니 데이터중에 
2) 요거트가 있는 장바구니 데이터가 있는지 확인한다

**/

SELECT CART_ID
FROM CART_PRODUCTS
WHERE
    CART_ID IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME LIKE 'Milk')
    AND NAME = 'Yogurt'
ORDER BY CART_ID ASC

