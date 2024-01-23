'''
1_000_000 * (1_000_000 ** (1/2)) -> 1번 방식
'''

# 1. 나름 가지치기 했지만, 백준에서는 통과 못했을 것
# def solution(n):
#     answer = 0
#     for num in range(2, n + 1):
#         sumVal = 0
#         for deno in range(1, int(num ** (1/2)) + 1):
#             if num % deno == 0:
#                 sumVal += 1
#             if sumVal == 2:
#                 break
#         if sumVal == 1:
#             answer += 1
#     return answer

# 2. 에라토스테네스의 체
def solution(n):
    answer = 0
    primeCheck = [False, False] + [True] * (n - 1)  # 소수가 아닌 경우 False로 갱신 예정

    for num in range(2, n + 1):
        if primeCheck[num]:  # True == 소수
            answer += 1
        for multi in range(2 * num, n + 1, num):
            primeCheck[multi] = False

    return answer