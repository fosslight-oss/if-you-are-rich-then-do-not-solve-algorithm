'''
징검다리 돌에 숫자가 있고, 한 번 밟으면 1씩 줄어들음
한 번에 여러 칸 건너뛸 수 있음
다음으로 밟을 수 있는 디딤돌이 여러개면 무조건 가장 가까운 디딤돌로 건너뛸 수 있음

한 번에 건너뛸 수 있는 칸 수 = k
0인 구간이 k-1개까지만 건널 수 있음

max([...k개]) = k
'''

from heapq import *

def solution(stones, k):
    answer = 0
    hq = []
    for i in range(k):
        heappush(hq, [-stones[i], i])
        answer = max(answer, stones[i])
    
    for i in range(k, len(stones)):
        heappush(hq, [-stones[i], i])
        while hq:
            if hq[0][1] > i - k: break
            heappop(hq)
        answer = min(answer, -hq[0][0])

    return answer
