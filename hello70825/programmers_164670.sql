/**

사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회
[조건] 중고 거래 게시물을 3건 이상 등록한 사용자
[조건] 전체 주소는 시, 도로명 주소, 상세 주소가 모두 보여야한다
[조건] 전화번호는 xxx-xxxx-xxx 형태여야한다
[정렬] 회원 ID 기준 DESC

**/

SELECT 
    UGU.USER_ID,
    UGU.NICKNAME,
    CONCAT(UGU.CITY, ' ', UGU.STREET_ADDRESS1, ' ', UGU.STREET_ADDRESS2) AS '전체주소',
    CONCAT(LEFT(UGU.TLNO, 3), '-', MID(UGU.TLNO, 4, 4), '-', RIGHT(UGU.TLNO, 4)) AS '전화번호'
FROM USED_GOODS_BOARD AS UGB 
    JOIN USED_GOODS_USER AS UGU
    ON UGB.WRITER_ID = UGU.USER_ID
GROUP BY UGB.WRITER_ID
HAVING COUNT(TITLE) >= 3
ORDER BY UGB.WRITER_ID DESC
