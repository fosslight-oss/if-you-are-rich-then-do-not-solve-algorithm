'''
n = 1,000,000이라 while문으로 풀어도 문제 없음
'''
def solution(a, b, n):
    answer = 0
    while n >= a:
        k = n // a
        n = n - a * k + k * b
        answer += k * b
    return answer
