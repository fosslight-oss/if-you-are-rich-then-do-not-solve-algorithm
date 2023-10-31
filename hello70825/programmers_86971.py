from collections import deque

def solution(n, wires):
    answer = 100

    for _ in range(len(wires)):
        visited = [0] * (n + 1)
        adj = [[] for _ in range(n + 1)]
        for i in range(len(wires)):
            if i == _: continue
            x, y = wires[i]
            adj[x].append(y)
            adj[y].append(x)
        color = 1
        for i in range(1, n+1):
            if visited[i] == 0:
                visited[i] = color
                q = deque([i])
                while q:
                    x = q.popleft()
                    for nx in adj[x]:
                        if visited[nx] == 0:
                            visited[nx] = color
                            q.append(nx)
                color += 1
        
        val = [0, 0, 0]
        for i in range(1, n+1):
            val[visited[i]] += 1
        answer = min(answer, abs(val[1] - val[2]))
    
    return answer
