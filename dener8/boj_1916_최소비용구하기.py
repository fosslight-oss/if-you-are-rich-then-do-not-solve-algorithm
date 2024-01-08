'''
n: 도시
m: 버스

A -> B 최소 비용
다익스트라
특징1. 양의 가중치
특징2. 한 점 -> 모든 점
'''
from heapq import heappush, heappop

n = int(input()) # 노드 개수
m = int(input()) # 엣지 개수
graph = [[] for _ in range(n + 1)] # 0번 노드 padding
for _ in range(m):
    nodeA, nodeB, dist = map(int, input().split())
    graph[nodeA].append([nodeB, dist])
startNode, endNode = map(int, input().split())

hq = []
dists = [float('inf') for _ in range(n + 1)]
heappush(hq, [0, startNode])
dists[startNode] = 0
while hq:
    dist, nodeA = heappop(hq)
    if dists[nodeA] < dist:
        continue
    # # 갱신
    # dists[nodeA] = dist
    for nodeB, dist in graph[nodeA]:
        if dists[nodeA] + dist < dists[nodeB]:
            heappush(hq, [dists[nodeA] + dist, nodeB])
            dists[nodeB] = dists[nodeA] + dist # 여기서 갱신
print(dists[endNode])

# dijkstra(startNode) 함수를 만들어서, 모든 startNode에 대응하게 만들 수도 있음