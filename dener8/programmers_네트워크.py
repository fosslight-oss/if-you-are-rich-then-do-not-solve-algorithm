'''
n: 컴퓨터의 개수
computers: 연결 관계 그래프 (2차원) cf. 자기 자신은 1로 표현

dfs, bfs 상관 없을 듯

i == j면 넘어가고,
if computers[i][j] == 1: dq.append(j)
node = dq.popleft() -> 이걸 다시 반복문으로

수를 늘려주는 부분은?
일단 dq에 넣고, visited 처리를 해야하나?
'''

# 1. bfs
# from collections import deque

# def solution(n, computers):
#     answer = 0
#     visited = [False] * n

#     dq = deque()
#     for i in range(n):
#         for j in range(n):
#             if computers[i][j] == 1 and not visited[j]: # 방문하지 않은 곳은 dq에 저장
#                 dq.append(j)
#                 while dq:
#                     node = dq.popleft()
#                     visited[node] = True
#                     for k in range(len(computers[node])):
#                         if computers[node][k] == 1 and not visited[k]:
#                             dq.append(k)
#                 answer += 1

#     return answer

'''
그냥 dfs() 한 바퀴를 돌고 돌아오면 answer 늘려주면 됨
'''

# 2. dfs
def dfs(node, n, computers, visited):
    visited[node] = True
    for i in range(n):
        if not visited[i] and computers[node][i] == 1:
            dfs(i, n, computers, visited)

def solution(n, computers):
    answer = 0

    visited = [False] * n
    for i in range(n):
        for j in range(n):
            if not visited[i] and computers[i][j] == 1:  # 방문하지 않았고,
                dfs(j, n, computers, visited)
                answer += 1

    return answer