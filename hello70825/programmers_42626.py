'''
경우의 수
- 음식 1개인데 K 미만
- 음식 1개인데 K 이상
- 음식 2개 이상인데 합치면 K 미만
- 음식 2개 이상인데 합치면 K 이상
'''

from heapq import *

def solution(scoville, K):
    hq = []
    for x in scoville:
        heappush(hq, x)

    answer = 0
    
    while len(hq) > 1:
        first = heappop(hq)
        if first >= K:
            break
        second = heappop(hq)
        new_score = first + second * 2
        heappush(hq, new_score)
        answer += 1
    
    if heappop(hq) >= K: return answer
    else: return -1
