from collections import defaultdict

def solution(numbers):
    answer = 0
    dd = defaultdict(int)
    for number in numbers:
        dd[number] = 1
    for i in range(10):
        if dd[i] == 0:
            answer += i

    return answer