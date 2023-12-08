dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1] # 북동남서

n, m = map(int, input().split())
r, c, d = map(int, input().split()) # d: 방향 (북동남서)
li = [list(map(int, input().split())) for _ in range(n)]

ans = 0
while True:
    if li[r][c] == 0:
        ans += 1
        li[r][c] = 2

    cleaned = True
    for _ in range(4):
        nd = (d - 1) % 4
        nx, ny = r + dx[nd], c + dy[nd]
        if 0 <= nx < n and 0 <= ny < m and li[nx][ny] == 0:
            r, c, d = nx, ny, nd
            cleaned = False
            break
        d = nd

    if cleaned:
        back_d = (d - 2) % 4
        back_x, back_y = r + dx[back_d], c + dy[back_d]
        if 0 <= back_x < n and 0 <= back_y < m and li[back_x][back_y] != 1:
            r, c = back_x, back_y
        else:
            print(ans)
            break