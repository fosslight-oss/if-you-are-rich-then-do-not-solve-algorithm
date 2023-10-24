/**

2021년에 가입한 회원중에 나이가 20세 이상 29세 이하인 회원이 몇명인지

**/

SELECT count(*)
FROM USER_INFO
WHERE JOINED >= '2021-01-01' AND JOINED < '2022-01-01' AND AGE >= 20 AND AGE 
<= 29
