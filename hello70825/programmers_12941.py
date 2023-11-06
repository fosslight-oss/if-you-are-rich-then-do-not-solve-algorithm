def solution(A,B):
    answer = 0

    A.sort()
    B.sort(reverse=True)
    
    return sum(A[i] * B[i] for i in range(len(A)))
