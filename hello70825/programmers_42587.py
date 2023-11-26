from collections import deque

def solution(priorities, location):
    q = deque()
    for i in range(len(priorities)):
        q.append([i, priorities[i]])
    
    answer = 0
    while q:
        x, p = q.popleft()
        if p >= max(priorities):
            priorities[x] = 0
            answer += 1
            if x == location:
                return answer
        else: q.append([x, p])
    return answer
