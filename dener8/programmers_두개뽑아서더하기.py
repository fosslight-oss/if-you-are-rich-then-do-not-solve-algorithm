from itertools import combinations as cb
def solution(numbers):
    answer = []
    for i in cb(numbers, 2):
        answer.append(sum(i))
    answer = sorted(set(answer))
    return answer