from collections import defaultdict

def solution(clothes):
    answer = 1
    dd = defaultdict(int)
    for option in clothes:
        dd[option[1]] += 1
    for key in dd:
        answer *= dd[key] + 1

    return answer - 1