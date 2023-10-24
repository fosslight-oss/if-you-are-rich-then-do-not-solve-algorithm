/**

첨부파일 경로 조회
[조건] 조회수가 가장 높은 중고거래 게시물
[경로 조건] 기본 파일 경우는 '/home/grep/src/'
[경로 조건] 다음 디렉토리는 게시글 ID 기준
[경로 조건] 파일 이름은 파일 ID, 파일 이름, 파일 확장자
[제한] 조회수가 가장 높은 게시물은 하나만 존재
[정렬] FILE_ID 기준 DESC

**/

SELECT CONCAT('/home/grep/src/', UGF.BOARD_ID, '/', UGF.FILE_ID, UGF.FILE_NAME, UGF.FILE_EXT) AS 'FILE_PATH'
FROM USED_GOODS_BOARD AS UGB JOIN USED_GOODS_FILE AS UGF ON UGB.BOARD_ID = UGF.BOARD_ID
WHERE VIEWS IN (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY UGF.FILE_ID DESC
