from itertools import combinations as cb

def solution(number):
    answer = 0
    for i in cb(number, 3):
        if sum(i) == 0:
            answer += 1

    return answer