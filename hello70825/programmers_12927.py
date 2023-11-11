'''
피로도 = 남은 일의 작업량을 제곱하여 더한값
N시간동안 피로도를 최소화하도록 일할거임
1시간 1만큼 처리 가능
N시간과 각 길에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴

제곱하는게 더 큰 값이니까 max값을 작게 = heapq
'''
import heapq

def solution(n, works):
    hq = []
    for x in works:
        heapq.heappush(hq, -x)
    for i in range(n):
        x = -heapq.heappop(hq)
        if x == 0: break
        heapq.heappush(hq, -(x - 1))
    
    answer = 0
    for x in hq:
        answer += x**2
    return answer
