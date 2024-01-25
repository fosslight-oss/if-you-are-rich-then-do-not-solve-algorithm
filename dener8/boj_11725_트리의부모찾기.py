'''
`루트 없는 트리` => 두 노드가 주어져도 누가 부모인지 모른다 (양방향)
각 노드의 부모 구하기

먼저 그래프를 만들고, 1을 찾아서 거기서부터 bfs 탐색
'''
from collections import deque

n = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
parentList = [0] * (n + 1)
for _ in range(n - 1):
    nodeA, nodeB = map(int, input().split())
    graph[nodeA].append(nodeB)
    graph[nodeB].append(nodeA)

dq = deque()
dq.append(1) # node
visited[1] = True
while dq:
    parent = dq.popleft()
    for child in graph[parent]:
        if not visited[child]:
            dq.append(child)
            visited[child] = True
            parentList[child] = parent

for answer in parentList[2:]:
    print(answer)