/**

식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
[조건] 서울에 위치한 식당
[조건] 리뷰 평균점수는 소수점 세번째 자리에서 반올림
[정렬] 평균점수 기준 DESC, 즐겨찾기수 기준 DESC

서울특별시, 서울시
**/

SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO AS RI
    JOIN REST_REVIEW AS RR
    ON RI.REST_ID = RR.REST_ID
WHERE ADDRESS LIKE '서울%'
GROUP BY RI.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC

