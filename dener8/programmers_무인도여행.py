'''
100 x 100

X: 바다
1~9: 무인도 - 식량

return
각 섬에서 머물 수 있는 일수 -> 오름차순
or
-1 (지낼 수 있는 곳 없을 때)

'''

'''
# 1. bfs
from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def get_score_by_bfs(x, y, maps, visited):
    n, m  = len(maps), len(maps[0])
    dq = deque()
    dq.append((x, y))
    visited[x][y] = True
    score = int(maps[x][y])
    while dq:
        x, y = dq.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != 'X' and not visited[nx][ny]:
                score += int(maps[nx][ny])
                dq.append((nx, ny))
                visited[nx][ny] = True
    return score

def solution(maps):
    answer = []
    n, m  = len(maps), len(maps[0])
    visited = [[False] * m for _ in range(n)] # 방문했으면 True
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visited[i][j]:
                score = get_score_by_bfs(i, j, maps, visited)
                answer.append(score)

    if not answer:
        return [-1]

    return sorted(answer)
'''

# 2. dfs
import sys

sys.setrecursionlimit(10000)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
n, m = 0, 0


def get_score_by_dfs(x, y, score, maps, visited):
    for k in range(4):
        nx, ny = x + dx[k], y + dy[k]
        if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != 'X' and not visited[nx][ny]:
            visited[nx][ny] = True
            score = get_score_by_dfs(nx, ny, score + int(maps[nx][ny]), maps, visited)
    return score


def solution(maps):
    global n, m
    n, m = len(maps), len(maps[0])
    visited = [[False] * m for _ in range(n)]
    answer = []

    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visited[i][j]:
                visited[i][j] = True
                score = 0
                score = get_score_by_dfs(i, j, score + int(maps[i][j]), maps, visited)
                answer.append(score)

    if not answer:
        return [-1]

    return sorted(answer)