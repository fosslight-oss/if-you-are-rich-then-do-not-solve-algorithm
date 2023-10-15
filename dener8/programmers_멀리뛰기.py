'''
맨 처음은 완전탐색 고려하고,
아니다 싶으면 바로 다른 방식 고려
'''

def solution(n):
    if n == 1:
        return 1
    if n == 2:
        return 2

    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 2

    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n] % 1234567