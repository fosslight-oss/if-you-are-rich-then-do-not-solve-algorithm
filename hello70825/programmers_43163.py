from collections import defaultdict as dfd, deque

def solution(begin, target, words):
    answer = 0
    visited = dfd(lambda: 0)
    visited[begin] = 1
    
    q = deque([begin])
    while q:
        x = q.popleft()
        for word in words:
            if visited[word]: continue
            cnt = 0
            for i in range(len(word)):
                if x[i] != word[i]:
                    cnt += 1
            if cnt > 1: continue
            visited[word] = visited[x] + 1
            q.append(word)
    
    answer = 0 if visited[target] == 0 else visited[target] - 1
    return answer
