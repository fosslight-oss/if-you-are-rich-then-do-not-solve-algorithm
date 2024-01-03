def solution(n, m):
    answer = [-1, -1]
    
    # 최대 공배수
    for i in range(min(n, m), 0, -1):
        if n % i == 0 and m % i == 0:
            answer[0] = i
            break
    
    # 최소 공약수
    answer[1] = n * m // answer[0]
    
    return answer
