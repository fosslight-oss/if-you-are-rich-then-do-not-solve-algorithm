/**

동물의 아이디, 생물종, 이름
[조건] 보호소에 들어올 당시 중성화하지 않음
[조건] 보호소를 나갈 당시에는 중성화되어야함
[정렬] 아이디 기준 ASC

SEX_UPON_INTAKE는 Spayed, Neutered가 아니어야함
SEX_UPON_OUTCOME는 Spayed, Neutered가 있어야함
**/

SELECT
    AI.ANIMAL_ID,
    AI.ANIMAL_TYPE,
    AO.NAME
FROM
    ANIMAL_INS AS AI
    JOIN ANIMAL_OUTS AS AO
    ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
    (SEX_UPON_INTAKE NOT LIKE '%Spayed%' AND SEX_UPON_INTAKE NOT LIKE '%Neutered%')
    AND
    (SEX_UPON_OUTCOME LIKE '%Spayed%' OR SEX_UPON_OUTCOME LIKE '%Neutered%')
ORDER BY
    AI.ANIMAL_ID ASC
