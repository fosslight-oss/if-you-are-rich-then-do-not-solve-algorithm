'''
수확한 귤 중 k개를 상자 하나에 담아 판매
서로 다른 종류의 수를 최소화

defaultdict 사용
'''
from collections import defaultdict as dfd


def solution(k, tangerine):
    dd = dfd(lambda: 0)
    for x in tangerine:
        dd[x] += 1
    a = [*dd.keys()]
    a.sort(key=lambda x: dd[x], reverse=True)

    val = 0
    answer = 0
    for x in a:
        val += dd[x]
        answer += 1
        if val >= k: break

    return answer