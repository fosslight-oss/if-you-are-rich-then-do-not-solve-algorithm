'''
인접행렬로 되어 있음
'''
from collections import deque

def solution(n, computers):
    answer = 0
    visited = [0] * n
    
    for i in range(n):
        if visited[i]: continue
        q = deque([i])
        visited[i] = 1
        while q:
            x = q.popleft()
            for nx in range(len(computers[x])):
                if computers[x][nx] and not visited[nx]:
                    visited[nx] = 1
                    q.append(nx)
        answer += 1
    
    return answer
