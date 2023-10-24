/**

식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL
[조건] 음식종류별로 즐겨찾기수가 가장 많은 식당
[정렬] 음식 종류 기준 DESC

한식 은돼지식당 732
일식 스시사카우스 230
분식 애플우스 151
양식 따띠따띠뜨 102
중식 만정 20
**/

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (SELECT FOOD_TYPE, MAX(FAVORITES) FROM REST_INFO GROUP BY FOOD_TYPE)
ORDER BY FOOD_TYPE DESC
