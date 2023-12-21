'''
n x m
0: 빈 방
1: 벽

(1, 1) -> (n, m) 이동
'''

# 틀린 답 (dfs) -> 시간초과
'''
import sys

dx, dy = [1, 0], [0, 1]
m, n = map(int, input().split())
li = [list(input()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
minVal = sys.maxsize

def dfs(x, y, cnt):
    global minVal
    visited[x][y] = True
    if x == n - 1 and y == m - 1:
        minVal = min(minVal, cnt)
        return
    for k in range(2):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
            if li[nx][ny] == '1':
                dfs(nx, ny, cnt + 1)
            else:
                dfs(nx, ny, cnt)
            visited[nx][ny] = False ## depth가 더 앞으로 갔던 코드를 봤던 기억이 있는데..

dfs(0, 0, 0)
print(minVal)
'''
# 다익스트라
from heapq import heappush, heappop

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
m, n = map(int, input().split())
li = [list(map(int, list(input().strip()))) for _ in range(n)]

dist = [[float('inf') for _ in range(m)] for _ in range(n)]
# 다익스트라는 방문 체크 X (재방문하며 최소 거리 찾아야 함)

queue = []
heappush(queue, (0, 0, 0)) # weight, x, y
dist[0][0] = 0
while queue:
    weight, x, y = heappop(queue)
    if x == n - 1 and y == m - 1:
        break
    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < m:
            # 최소 경로인지 확인 (queue에 넣을건지 확인)
            if weight + li[nx][ny] < dist[nx][ny]:
                dist[nx][ny] = weight + li[nx][ny]
                heappush(queue, (dist[nx][ny], nx, ny))
print(dist[-1][-1])