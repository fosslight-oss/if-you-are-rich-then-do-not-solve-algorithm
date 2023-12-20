'''
n: 노드 수
m: 엣지 수
x: 도착 노드

x노드에 왔다 가는게 가장 오래 걸리는 노드는?

A -> X -> A: 다시 돌아와야 함
A -> X (그래프 거꾸로 만들기)
X -> A (그래프 그대로)
이렇게 둘로 나눠서 합치자

'''
from heapq import heappush, heappop
n, m, x = map(int, input().split())
origin, reverse = [[] for _ in range(n + 1)], [[] for _ in range(n + 1)]

for _ in range(m):
    start, end, weight = map(int, input().split())
    origin[start].append((weight, end))
    reverse[end].append((weight, start))

originDist, reverseDist = [float('inf') for _ in range(n + 1)], [float('inf') for _ in range(n + 1)]
originQueue, reverseQueue = [], []

# X -> A (origin)
heappush(originQueue, (0, x))
originDist[x] = 0
while originQueue:
    dist, node = heappop(originQueue)
    if originDist[node] < dist:
        continue
    # node 탐색
    for weight, child in origin[node]:
        if weight + dist < originDist[child]: # 이렇게해야 pruning 가능
            heappush(originQueue, (weight + dist, child))
            originDist[child] = weight + dist

# A -> X (reverse)
heappush(reverseQueue, (0, x))
while reverseQueue:
    dist, node = heappop(reverseQueue)
    if reverseDist[node] < dist:
        continue
    for weight, child in reverse[node]:
        if weight + dist < reverseDist[child]:
            reverseDist[child] = weight + dist
            heappush(reverseQueue, (weight + dist, child))

answer = 0 # max
for idx in range(1, n + 1):
    answer = max(answer, originDist[idx] + reverseDist[idx])
print(answer)