/**

년, 월 별로 상품을 구매한 회원의 비율
[조건] 2021년에 가입한 회원
[조건] 상품을 구매한 회원 수 / 전체 회원 수
[조건] 비율은 소수점 두번째 자리에서 반올림
[정렬] 년 ASC, 월 ASC

1) 2021년에 가입한 회원, UNION으로 2021년에 가입한 사람 수를 가져옴
1월 47명
2월 40명
3월 6명
**/


SELECT YEAR, MONTH, COUNT(USER_ID) AS 'PUCHASED_USERS', ROUND(COUNT(USER_ID) / TOTAL, 1) AS PUCHASED_RATIO
FROM (
        SELECT DISTINCT 
                YEAR(OS.SALES_DATE) AS YEAR,
                MONTH(OS.SALES_DATE) AS MONTH,
                UI.USER_ID
        FROM 
            USER_INFO AS UI
            JOIN ONLINE_SALE AS OS
            ON UI.USER_ID = OS.USER_ID
        WHERE
            YEAR(UI.JOINED) = 2021
    ) AS A
    JOIN
    (
        SELECT COUNT(*) AS TOTAL
        FROM (
            SELECT DISTINCT USER_ID
            FROM USER_INFO
            WHERE YEAR(JOINED) = 2021
        ) AS C
    ) AS B ON 1 = 1
GROUP BY YEAR, MONTH
ORDER BY YEAR ASC, MONTH ASC
