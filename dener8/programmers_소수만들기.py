from itertools import combinations as cb

def isPrime(n):
    cnt = 1
    for num in range(2, n + 1):
        if n % num == 0:
            cnt += 1
    if cnt == 2:
        return True
    return False


def solution(nums):
    answer = 0

    for i in cb(nums, 3):
        if isPrime(sum(i)):
            answer += 1

    return answer