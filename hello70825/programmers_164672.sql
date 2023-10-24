/**

게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태
[조건] 2022년 10월 5일에 등록
[조건] 거래상태 -> SALE = 판매중, RESERVED = 예약중, DONE = 거래완료로 출력
[정렬] 게시글 ID 기준 DESC

**/

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, IF(`STATUS` = 'SALE', '판매중', IF(`STATUS` = 'RESERVED', '예약중', '거래완료'))
FROM USED_GOODS_BOARD
WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
ORDER BY BOARD_ID DESC
