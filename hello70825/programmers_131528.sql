/**
나이 정보가 없는 회원이 몇 명인지 출력
전체 = 200명, 나이 NULL = 4명
**/

SELECT COUNT(*)
FROM USER_INFO
WHERE AGE IS NULL
