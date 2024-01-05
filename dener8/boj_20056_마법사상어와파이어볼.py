'''
2시간 소요.. 이거 맞나 😅

n x n
m: 파이어볼 개수
k: 명령 횟수

'1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.'
=> 이게 뭔 말임??

li[][]의 원소를 deque()으로 관리해서, 앞뒤로 뺄 수 있게 만들까?

1. 파이어볼 이동
    : 탐색 전에 미리 (x, y)를 받아둘 필요가 있다. 그 장소의 파이어볼만 이동시켜야 하니까
2. 파이어볼 2개 이상인 곳 => 연산
    (1) 하나로 합치기
        -> (2)로 가기전에 (x, y)를 받아둘 필요가 있음.
    (2) 4개의 파이어볼로 나누기

    하나로 합쳐진 후에 다시 4개로 나뉨 *** 이동은 다음 턴에 하는 것에 주의!
'''

from collections import deque

dx, dy = [-1, -1, 0, 1, 1, 1, 0, -1], [0, 1, 1, 1, 0, -1, -1, -1]

def get_fireballs_idx(num):
    fireballs_idx = []
    global n, li
    for i in range(n):
        for j in range(n):
            if len(li[i][j]) >= num :
                fireballs_idx.append((i, j, len(li[i][j])))
    return fireballs_idx

n, m, k = map(int, input().split())
li = [[deque() for _ in range(n)] for _ in range(n)]
fireballs = []
for i in range(m):
    x, y, mass, speed, dir = map(int, input().split())
    fireballs.append([x - 1, y - 1, mass, speed, dir])
for fireball in fireballs:
    x, y, mass, speed, dir = fireball
    li[x][y].append((mass, speed, dir))

for _ in range(k): # k번 명령
    # 1. 파이어볼 이동
    fireballs_idx = get_fireballs_idx(1) # x, y, cnt (기존 파이어볼 개수)
    for x, y, cnt in fireballs_idx:
        for _ in range(cnt):
            mass, speed, dir = li[x][y].popleft()
            nx, ny = (x + dx[dir] * speed) % n, (y + dy[dir] * speed) % n
            li[nx][ny].append((mass, speed, dir))

    # 2. 파이어볼 2개 이상인 곳 => 연산
    fireballs_idx = get_fireballs_idx(2)
    for x, y, cnt in fireballs_idx:
        mass_sum, speed_sum = 0, 0
        even_dir, odd_dir = True, True
        for _ in range(cnt):
            mass, speed, dir = li[x][y].popleft()
            mass_sum += mass
            speed_sum += speed
            if dir % 2 == 1: # 홀수면
                even_dir = False
            elif dir % 2 == 0:
                odd_dir = False
        dirs = []
        if even_dir or odd_dir:
            dirs = [0, 2, 4, 6]
        else:
            dirs = [1, 3, 5, 7]

        for i in range(4):
            new_mass, new_speed, new_dir = mass_sum // 5, speed_sum // cnt, dirs[i]
            if not new_mass:
                continue
            # nx, ny = (x + dx[new_dir] * new_speed) % n, (y + dy[new_dir] * new_speed) % n
            li[x][y].append((new_mass, new_speed, new_dir))

ans = 0
for i in range(n):
    for j in range(n):
        for k in range(len(li[i][j])):
            ans += li[i][j][k][0]

print(ans)