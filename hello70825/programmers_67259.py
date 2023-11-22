from heapq import *
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1] # ↓, ↑, →, ←

def solution(board):
    n = len(board)
    m = len(board[0])
    
    answer = 0
    
    visited =[[[-1] * 4 for __ in range(m)] for _ in range(n)]
    for i in range(4):
        visited[0][0][i] = 0

    hq = []
    if board[0][1] == 0:
        heappush(hq, [100, 0, 1, 2]) # 비용, x, y, 방향
        visited[0][1][2] = 100
    if board[1][0] == 0:
        heappush(hq, [100, 1, 0, 0]) # 비용, x, y, 방향
        visited[1][0][0] = 100
    while hq:
        val, x, y, z = heappop(hq)
        if visited[x][y][z] != val: continue
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 0 and (visited[nx][ny][i] == -1 or visited[nx][ny][i] > visited[x][y][z] + (100 if i == z else 600)):
                if i == z:visited[nx][ny][i] = visited[x][y][z] + 100
                else:visited[nx][ny][i] = visited[x][y][z] + 600
                heappush(hq, [visited[nx][ny][i], nx, ny, i])
    
    answer = 250000000
    for i in range(4):
        if visited[n-1][m-1][i] != -1:
            answer = min(answer, visited[n-1][m-1][i])
    return answer
