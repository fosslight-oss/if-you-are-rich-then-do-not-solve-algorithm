/**

회원 이름, 리뷰 텍스트, 리뷰 작성일
[조건] 리뷰를 가장 많이 작성한 회원
[정렬] 리뷰작성일 기준 ASC, 리뷰 텍스트 기준 ASC

1. COUNT(REVIEW_ID)가 가장 높은 MEMBER_ID를 찾을 수 있게해야함
서브쿼리에 LIMIT를 지원하지 않음
SELECT MEMBER_ID
FROM REST_REVIEW
GROUP BY MEMBER_ID
**/

SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    MEMBER_PROFILE AS MP
    JOIN REST_REVIEW AS RR
    ON MP.MEMBER_ID = RR.MEMBER_ID
WHERE
    RR.MEMBER_ID IN (
        SELECT MEMBER_ID
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        HAVING COUNT(REVIEW_ID) = (SELECT DISTINCT MAX(CNT)
                            FROM (
                                SELECT MEMBER_ID, COUNT(REVIEW_ID) AS CNT
                                FROM REST_REVIEW
                                GROUP BY MEMBER_ID
                            ) AS A)
    )
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC
