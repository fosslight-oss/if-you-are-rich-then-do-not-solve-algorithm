'''
n x n
n^2: 학생수
(1, 1) ~ (n, n) *** (1, 1) 시작임에 주의!

[x, y, near_empty, near_like] 이렇게 한 번에 관리하면 편할 듯
near_empty: 4방향(최대)에서 비어있는 칸의 개수
near_like: 4방향(최대)에서 좋아하는 사람의 수
'''
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n = int(input())
likes = [[0, 0, 0, 0] for _ in range(n * n + 1)]
order = []
for _ in range(n * n):
    like = list(map(int, input().split()))
    likes[like[0]] = like[1 : ]
    order.append(like[0])

li = [[0] * n for _ in range(n)]
cnt = 0
while cnt != n * n:
    num = order[cnt]
    cnt += 1
    info = []
    for i in range(n):
        for j in range(n):
            if li[i][j] != 0:
                continue
            near_empty, near_like = 0, 0
            for k in range(4):
                nx, ny = i + dx[k], j + dy[k]
                if 0 <= nx < n and 0 <= ny < n:
                    if li[nx][ny] == 0:
                        near_empty += 1
                    if li[nx][ny] in likes[num]:
                        near_like += 1
            info.append([i, j, near_empty, near_like])
    # near_like 1순위
    # near_empty 2순위
    # i, j 3순위
    # 값이 비어있는지 아닌지 체크하고 삽입 (-> 위에서 처리)
    info = sorted(info, key = lambda x: [-x[3], -x[2], x[0], x[1]])
    li[info[0][0]][info[0][1]] = num

# 만족도 측정
answer = 0
for i in range(n):
    for j in range(n):
        score = 0
        for k in range(4):
            nx, ny = i + dx[k], j + dy[k]
            if 0 <= nx < n and 0 <= ny < n:
                if li[nx][ny] in likes[li[i][j]]:
                    score += 1
        if score:
            answer += 10 ** (score - 1)

print(answer)


