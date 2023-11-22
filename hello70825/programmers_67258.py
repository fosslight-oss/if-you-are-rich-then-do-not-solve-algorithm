'''
특정 범위의 보석을 모두 구매
+ 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아야함
'''
from collections import defaultdict as dfd

def solution(gems):
    answer = []
    n = len(gems)
    
    all_total = 0
    total_dd = dfd(lambda: 0)
    for gem in gems:
        if not total_dd[gem]: all_total += 1
        total_dd[gem] += 1
    if all_total == 1: return [1, 1]
    
    l, r = 0, 0
    total = 0
    dd = dfd(lambda: 0)
    for i in range(len(gems)):
        if not dd[gems[i]]: total += 1
        dd[gems[i]] += 1
        if total == all_total: r = i; break
    
    answer = [l, r]
    
    while r < len(gems):
        if total == all_total:
            if answer[1] - answer[0] > r - l: answer = [l, r]
            dd[gems[l]] -= 1
            if dd[gems[l]] == 0: total -= 1
            l += 1
        else:
            r += 1
            if r >= len(gems): break
            if not dd[gems[r]]: total += 1
            dd[gems[r]] += 1
    answer = [answer[0] + 1, answer[1] + 1]
    
    return answer
