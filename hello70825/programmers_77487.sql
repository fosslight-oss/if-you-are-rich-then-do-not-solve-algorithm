/**

등록한 공간의 정보
[조건] 공간을 둘 이상 등록한 사람을 헤비 유저라고 함
[정렬] ID 기준 ASC

**/

SELECT *
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID FROM PLACES GROUP BY HOST_ID HAVING COUNT(ID) >= 2)
