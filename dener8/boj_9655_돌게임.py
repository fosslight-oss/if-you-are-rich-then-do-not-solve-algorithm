'''
n: 돌 개수
1개, 3개 가져갈 수 있음
마지막 돌을 가져가는 사람이 승리

상근 먼저 시작

dp[1] 1
dp[2] 1 1
dp[3] 3
dp[4] 3 1
dp[5] 3 3 1
dp[6] 3 3
dp[7] 3 3 1
dp[8]

'''
n = int(input())
if n % 2:
    print('SK')
else:
    print('CY')