/**

보호소에서 몇 시에 가장 입양이 활발하게 일어나는지 각 시간대별로 입양이 몇 건 
발생했는지 조회
[조건] 09:00 ~ 19:59까지 확인한다
[정렬] 시간대 기준 ASC

**/

SELECT HOUR, COUNT(HOUR)
FROM (
    SELECT DATE_FORMAT(DATETIME, '%H') AS HOUR
    FROM ANIMAL_OUTS
) AS ANIMAL_OUTS_A
WHERE HOUR >= 9 AND HOUR < 20
GROUP BY HOUR
ORDER BY HOUR ASC
