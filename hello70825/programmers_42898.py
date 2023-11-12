def solution(m, n, puddles):
    
    arr = [[0] * (n+1) for _ in range(m+1)]
    arr[1][1] = 1
    
    # 먼저 1행, 1열 전부 1로 채우기
    for i in range(2, m+1):
        if [i, 1] in puddles: break
        arr[i][1] = 1
    for i in range(1, n+1):
        if [1, i] in puddles: break
        arr[1][i] = 1

    # 나머지 채우기
    for i in range(2, m+1):
        for j in range(2, n+1):
            if [i, j] in puddles: continue
            arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000007

    return arr[m][n]
