'''
N x N

이중 for문을 돌며,
li[i][j]와 li[j][i]을 한 번에 체크.
해당 위치에서 다음 위치로 이동이 가능한지 dp[][]에 합산하면서 진행
'''
n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1 # 시작점이므로 무조건 1가지의 방법으로 도달할 수 있다고 가정

for i in range(n):
    for j in range(n):
        cur = li[i][j]
        if li[i][j] == 0: # 종착점에 다다랐을 경우
            break

        if i + cur < n:
            dp[i + cur][j] += dp[i][j]
        if j + cur < n:
            dp[i][j + cur] += dp[i][j]

print(dp[-1][-1])