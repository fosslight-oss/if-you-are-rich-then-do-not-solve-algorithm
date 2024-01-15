'''
동시에 진입 노드가 0이 되는 점들의 작업 시간 중 min값만 누적해가면 됨

위상정렬 조건
    1. Direct
    2. Acyclic **
'''
from collections import deque

n = int(input())
graph = [[] for _ in range(n + 1)] # padding
degrees = [0] * (n + 1)
scores = [0] * (n + 1) # padding
dp = [0] * (n + 1)
dq = deque()
for i in range(1, n + 1):
    li = list(map(int, input().split()))
    scores[i] = li[0]
    dp[i] = li[0] ###
    degrees[i] = li[1]
    if li[1] == 0:
        dq.append(i)  # 부모 노드 삽입
    for node in li[2:]:
        graph[node].append(i) # i -> node (부모 -> 자식) 방향 그래프

while dq:
    # 현재 뺄 수 있는 여러 개 가운데 어떤 것을 먼저 뺄 것인가 => dp로 처리
    parent = dq.popleft()
    for child in graph[parent]:
        degrees[child] -= 1
        dp[child] = max(dp[parent] + scores[child], dp[child])
        # 진입노드 0일 때 deque에 삽입
        if degrees[child] == 0:
            dq.append(child)

print(max(dp))