def solution(t, p):
    answer = 0

    part = int(p)
    for i in range(len(t) - len(p) + 1):
        num = int(t[i: i + len(p)])
        if num <= part:
            answer += 1

    return answer