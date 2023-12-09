def solution(n, s):
    answer = []

    if not s // n:
        return [-1]

    for _ in range(n):
        answer.append(s // n)
    left = s % n
    idx = 0
    while left:
        if idx == n:
            idx = 0
        answer[idx] += 1
        left -= 1
        idx += 1

    return sorted(answer)