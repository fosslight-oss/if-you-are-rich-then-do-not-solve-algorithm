'''
11:15 ~ 1시간 이상 소요

n x n
m: 물고기 마리
상어 1마리 = 크기 2
상어 1초에 1칸씩 이동 (상하좌우)

작은 물고기 있는 곳: 먹 O 이동 O
같은 물고기 있는 곳: 먹 X 이동 O
큰 물고기 있는 곳: 먹 X 이동 X

"아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다."

작은 물고기를 먼저 먹어야하는 조건은 없네!
단, 거리가 가장 가까운 것부터 먹어야 함

- 상어 크기를 인자로 가져 탐색 가능을 반환하는 함수

'''

'''
# 전체에 먹을 수 있는 것이 있어도, 먹을 수 없는 것에 감싸있으면 소용이 없다!
# bfs로 탐색하면서, 도달 가능하다면 return
from collections import deque
dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0] # 문제의 우선순위에 따라 '상좌우하' 순서

def keep_going(shark_size, x, y):
    global n
    dq = deque()
    dq.append((x, y))
    visited = [[False] * n for _ in range(n)]
    visited[x][y] = True

    while dq:
        x, y = dq.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if li[nx][ny] == shark_size or li[nx][ny] == 0: # 이동만 가능한 경우
                    dq.append((nx, ny))
                    visited[nx][ny] = True
                elif li[nx][ny] < shark_size:
                    return True
    return False

n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]

# 현재 상어위치 확인
shark_x, shark_y, shark_size, left_for_size_up = 0, 0, 2, 2
for i in range(n):
    for j in range(n):
        if li[i][j] == 9:
            shark_x, shark_y = i, j

# 먹을 수 있는 게 있다면
ans = 0
while keep_going(shark_size, shark_x, shark_y):
    dq = deque()
    dq.append((shark_x, shark_y, 0))
    visited = [[False] * n for _ in range(n)]
    visited[shark_x][shark_y] = True
    candi = [] # [x, y, cnt]
    while dq:
        x, y, cnt = dq.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if li[nx][ny] == shark_size or li[nx][ny] == 0: # 이동만 가능한 경우
                    dq.append((nx, ny, cnt + 1))
                    visited[nx][ny] = True

                elif li[nx][ny] < shark_size:
                    candi.append([nx, ny, cnt])

    candi = sorted(candi, key = lambda x : [x[2], x[0], x[1]])
    fish_x, fish_y, cnt = candi[0]
    ans += cnt
    left_for_size_up -= 1
    li[fish_x][fish_y], li[shark_x][shark_y] = 9, 0
    shark_x, shark_y = fish_x, fish_y
    if left_for_size_up == 0:
        shark_size += 1
        left_for_size_up = shark_size

print(ans)
'''

from collections import deque

dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]

def bfs(shark_size, x, y):
    global n, li
    dq = deque()
    dq.append((x, y, 0))
    visited = [[False] * n for _ in range(n)]
    visited[x][y] = True
    prey = []

    while dq:
        x, y, dist = dq.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if li[nx][ny] <= shark_size:  # 이동 가능
                    dq.append((nx, ny, dist + 1))
                    visited[nx][ny] = True
                    if 0 < li[nx][ny] < shark_size:  # 먹을 수 있는 물고기
                        prey.append((dist + 1, nx, ny))

    return sorted(prey, key=lambda x: (x[0], x[1], x[2]))  # 거리, x, y 순으로 정렬


n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]

# 상어 위치 확인
shark_x, shark_y, shark_size, left_for_size_up = 0, 0, 2, 2
for i in range(n):
    for j in range(n):
        if li[i][j] == 9:
            shark_x, shark_y = i, j

ans = 0
while True:
    prey_list = bfs(shark_size, shark_x, shark_y)
    if not prey_list:
        break

    dist, prey_x, prey_y = prey_list[0]
    ans += dist
    li[prey_x][prey_y] = 9
    li[shark_x][shark_y] = 0
    shark_x, shark_y = prey_x, prey_y
    left_for_size_up -= 1
    if left_for_size_up == 0:
        shark_size += 1
        left_for_size_up = shark_size

print(ans)
