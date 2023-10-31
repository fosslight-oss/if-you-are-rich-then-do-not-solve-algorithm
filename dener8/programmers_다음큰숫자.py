def count(num):
    remain = []
    while num:
        remain.append(num % 2)
        num //= 2
    cnt = 0
    for i in remain:
        if i == 1:
            cnt += 1
    return cnt


def solution(n):
    answer = 0
    cnt = count(n)
    for i in range(n + 1, 1000001):
        if cnt == count(i):
            return i

    return answer