'''
15:07 ~
"위상정렬"이라는 걸 알고 풀지만, 최대한 문제에서 근거를 찾아보자

n명의 학생 키 순서대로 정렬
두 학생끼리 키 비교하는 방법으로 측정(일부 학생만)
A B -> A가 앞

위상정렬의 결과는 여러 개일 수 있다.
=> O(V+E)
'''
from collections import deque

n, m = map(int, input().split()) # 노드 수, 비교 횟수
graph = [[] for _ in range(n + 1)]
cnt = [0] * (n + 1) # 선행노드 cnt 리스트
result = []
for _ in range(m):
    parent, child = map(int, input().split())
    graph[parent].append(child)
    cnt[child] += 1

dq = deque()
for node in range(1, n + 1):
    if cnt[node] == 0:
        dq.append(node)

# 선행노드가 0이 될 때 dq에 삽입
while dq:
    parent = dq.popleft()
    result.append(parent)
    for child in graph[parent]:
        cnt[child] -= 1
        if cnt[child] == 0:
            dq.append(child)

print(*result)
