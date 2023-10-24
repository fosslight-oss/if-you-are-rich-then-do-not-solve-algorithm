/**

회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문
[조건] 생일이 3월
[조건] 여성 회원
[조건] 전화번호가 NULL이면 제외
[정렬] 회원ID 기준 오름차순

**/

SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d')
FROM MEMBER_PROFILE
WHERE DATE_FORMAT(DATE_OF_BIRTH, '%m') = '03' AND GENDER = 'W' AND TLNO IS NOT NULL
ORDER BY MEMBER_ID ASC
