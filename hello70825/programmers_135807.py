'''
카드 절반씩, 가장 큰 양의 정수 a를 구하려고 함
1) 철수가 가진 모든 카드를 나눌 수 있고, 영희 카드는 모두 나눌 수 없는 a
2) 반대의 경우도 성립
이중에 하나를 a라고 함

- arrayA 최대공약수를 구해서 arrayB 배열 돌리기
- arrayB 최대공약수를 구해서 arrayA 배열 돌리기
'''
from math import gcd

def solution(arrayA, arrayB):
    a_gcd = arrayA[0]
    for i in range(1, len(arrayA)):
        a_gcd = gcd(a_gcd, arrayA[i])

    b_gcd = arrayB[0]
    for i in range(1, len(arrayB)):
        b_gcd = gcd(b_gcd, arrayB[i])

    a_flag = True
    for x in arrayB:
        if x % a_gcd == 0:
            a_flag = False
    b_flag = True
    for x in arrayA:
        if x % b_gcd == 0:
            b_flag = False

    if a_flag and b_flag:
        return max(a_gcd, b_gcd)
    elif a_flag:
        return a_gcd
    elif b_flag:
        return b_gcd
    return 0