'''
11:49 ~ 12:42

n x n
(r, c)
(1, 1) ~ (n, n)

[8개의 방향]
1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙

(1) 구름 생성
(2) 구름 이동
(3) 구름 있는 칸에 비 +1씩 내리고, 구름 사라짐
(4) 해당 칸에 대각선 물복사 실행

(1) 구름 생성: 첫 번째의 생성과 다르게, 2 이상인 칸에 구름 생성 (물의 양 -2)
            (3)에서 구름이 사라진 칸이 아니어야 함
'''
dx, dy = [0, 0, -1, -1, -1, 0, 1, 1, 1], [0, -1, -1, 0, 1, 1, 1, 0, -1] # [0] padding

n, m = map(int, input().split())
li = [list(map(int, input().split())) for _ in range(n)]
moves = [list(map(int, input().split())) for _ in range(m)] # [dir, dist]

clouds = [(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1)]
for dir, dist in moves:
    # (2) 구름 이동
    for idx, cloud in enumerate(clouds):
        x, y = cloud[0], cloud[1]
        nx, ny = (x + dx[dir] * dist) % n, (y + dy[dir] * dist) % n
        clouds[idx] = (nx, ny)
    # (3) 구름 있는 칸에 비 내리기
    for x, y in clouds:
        li[x][y] += 1
    # (4) 물복사
    for x, y in clouds:
        diagonal = [(x-1, y-1), (x-1, y+1), (x+1, y-1), (x+1, y+1)]
        cnt = 0
        for nx, ny in diagonal:
            if 0 <= nx < n and 0 <= ny < n:
                if li[nx][ny] > 0:
                    cnt += 1
        li[x][y] += cnt

    # (3)의 구름 없애고, 새로운 (1) (구름 생성)
    new_clouds = []
    for x in range(n):
        for y in range(n):
            if li[x][y] >= 2 and (x, y) not in clouds:
                new_clouds.append((x, y))
                li[x][y] -= 2
    clouds = new_clouds

# 정답 출력
ans = 0
for x in range(n):
    for y in range(n):
        ans += li[x][y]
print(ans)