from collections import deque

def solution(A, B):
    A = sorted(A, reverse=True)
    B = deque([*sorted(B, reverse=True)])
    idx = 0
    answer = 0
    while B:
        if B[0] > A[idx]:
            B.popleft()
            answer += 1
        else: B.pop()
        idx += 1
    return answer
