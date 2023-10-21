'''
N = 1_000_000
queue, deque을 사용하면 O(N^2)
heap을 사용하면 O(NlogN)까지 줄일 수 있음
'''

# 파이썬은 최소힙이 default
from heapq import heappush, heappop, heapify


def solution(operations):
    min_heap = []
    max_heap = []
    for i in range(len(operations)):
        oper, num = operations[i].split(" ")
        num = int(num)

        if oper == 'I':
            heappush(min_heap, num)
            heappush(max_heap, -num)
        elif oper == 'D':
            if not min_heap:
                continue
            if num == -1:  # 최솟값 삭제
                max_heap.remove(heappop(min_heap) * -1)
            elif num == 1:  # 최댓값 삭제
                min_heap.remove(heappop(max_heap) * -1)

    if not min_heap:
        return [0, 0]

    min_heap = sorted(min_heap)
    return [min_heap[-1], min_heap[0]]