def solution(d, budget):
    answer = 0
    d.sort()
    for x in d:
        if budget >= x:
            budget -= x
            answer += 1
    return answer
