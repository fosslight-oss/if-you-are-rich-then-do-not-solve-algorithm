'''
끝은 그냥 위에거 그대로 가져오기
나머지는 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
'''

def solution(triangle):
    answer = 0

    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0:
                triangle[i][j] += triangle[i - 1][j]
                continue
            if j == len(triangle[i]) - 1:
                triangle[i][j] += triangle[i - 1][j - 1]
                continue
            triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])

    answer = max(triangle[-1])

    return answer