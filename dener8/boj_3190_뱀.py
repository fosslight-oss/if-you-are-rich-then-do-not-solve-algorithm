'''
벽 or 자기자신 부딪히면 게임 종료

사과가 있든 없든, 뱀으로 채워지지만 꼬리가 계속 있냐 없냐의 차이

0: 빈칸
1: 사과
2: 뱀
'''
from collections import deque

n = int(input()) # 보드의 크기
k = int(input()) # 사과의 개수
li = [[0] * n for _ in range(n)]
for _ in range(k):
    x, y = map(int, input().split())
    li[x - 1][y - 1] = 1
l = int(input())
dir_dq = deque()
for _ in range(l):
    x, c = input().split()
    x = int(x)
    dir_dq.append((x, c))

'''
- 벽 닿으면 게임 종료
- 뱀(2) 닿으면 게임 종료

sec, dir 등 필요

이동 중에 꼬리를 삭제하려면
1. 꼬리 정보를 당시 방향과 함께 저장
2. 뱀이 걸쳐있는 idx를 계속 저장
* 2가 더 간단하겠다!

'''
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0] # 우하좌상
sec, dir = 0, 0 # 경과 시간, 방향
x, y = 0, 0 # 머리 현재 위치
li[0][0] = 2
snake = deque()
snake.append((0, 0))

while True:
    sec += 1
    nx, ny = x + dx[dir], y + dy[dir]

    if not (0 <= nx < n and 0 <= ny < n): # 범위 밖이면
        break
    if li[nx][ny] == 2: # 뱀에 닿으면
        break
    if li[nx][ny] == 1: # 사과면
        li[nx][ny] = 2
        x, y = nx, ny
        snake.append((x, y))
    elif li[nx][ny] == 0: # 빈 칸이면
        li[nx][ny] = 2
        x, y = nx, ny
        snake.append((x, y))
        tail_x, tail_y = snake.popleft()
        li[tail_x][tail_y] = 0

    # 이동 -> 방향 변경 이 순서로
    # 그러므로, 뒤에서 방향 바꿔주기
    if dir_dq and dir_dq[0][0] == sec:
        if dir_dq.popleft()[1] == 'D': # 오른쪽으로 90도 회전
            dir = (dir + 1) % 4
        else: # 왼쪽으로 90도 회전
            dir = (dir - 1) % 4

print(sec)


