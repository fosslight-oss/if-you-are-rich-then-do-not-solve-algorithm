'''
1. 범위 밖
2. 장애물
'''
dic = {'N': (-1, 0), 'S': (1, 0), 'W': (0, -1), 'E': (0, 1)}

def solution(park, routes):
    n, m = len(park), len(park[0])
    # 출발점 찾기
    for i in range(n):
        for j in range(m):
            if park[i][j] == 'S':
                x, y = i, j

    # 탐색
    for route in routes:
        dir, dist = route.split()
        dist = int(dist)
        x_weight, y_weight = dic[dir]
        nx, ny = x + x_weight * dist, y + y_weight * dist
        # 1. 범위 밖
        if not (0 <= nx < n and 0 <= ny < m):
            continue
        # 2. 장애물
        flag = True
        if x == nx:  # y가 바뀐 것
            if y < ny:
                for i in range(y, ny + 1):
                    if park[x][i] == 'X':
                        flag = False
            else:
                for i in range(ny, y + 1):
                    if park[x][i] == 'X':
                        flag = False
        else:  # x가 바뀐 것
            if x < nx:
                for i in range(x, nx + 1):
                    if park[i][y] == 'X':
                        flag = False
            else:
                for i in range(nx, x + 1):
                    if park[i][y] == 'X':
                        flag = False
        if flag:
            x, y = nx, ny

    return [x, y]