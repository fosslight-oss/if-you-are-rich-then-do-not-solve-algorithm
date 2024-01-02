'''
간단한 heap 문제
'''
from heapq import heappush, heappop

def solution(n, works):
    hq = []
    for work in works:
        heappush(hq, (work * -1, work))  # 최대힙 만들기

    if n > sum(works):
        n = sum(works)

    while n:
        n -= 1
        work = heappop(hq)[1] - 1
        if work:
            heappush(hq, (work * -1, work))

    answer = 0
    for work in hq:
        answer += work[1] ** 2

    return answer