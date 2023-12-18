'''
n x n
0: 빈칸
1: 벽
return: m개의 지점을 순서대로 방문할 수 있는 서로 다른 방법의 수

sol)
n이 충분히 작으므로, 완전탐색으로 걸러내면 됨
'''

import sys

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n, m = map(int, input().split())
li = [list(map(int, input().split())) for _ in range(n)]
x, y = map(int, input().split())
x, y = x - 1, y - 1
order = [] # [x, y]
for _ in range(m - 1):
  a, b = map(int, input().split())
  order.append([a - 1, b - 1])

ans = 0
visited = [[False] * n for _ in range(n)] # False: 방문한 적 없음 (방문 가능)

def dfs(x, y, idx):
  global ans, n, m
  if idx == m - 1:
    ans += 1
    return
  for k in range(4):
    nx, ny = x + dx[k], y + dy[k]
    if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and li[nx][ny] == 0:
      # idx 확인
      visited[nx][ny] = True
      if order[idx] == [nx, ny]:
        dfs(nx, ny, idx + 1)
      else:
        dfs(nx, ny, idx)
      visited[nx][ny] = False

visited[x][y] = True
dfs(x, y, 0)
print(ans)

