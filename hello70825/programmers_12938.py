'''
최고의 집합
- 각 원소의 합이 S
- 각 원소의 곱이 최대

균등하게 수를 배분할 때 제일 좋을 듯 (정사각형 넓이 vs 직사각형 넓이 처럼)

'''

def solution(n, s):
    if n > s: return [-1]

    mok = s // n
    answer = [mok for i in range(n)]
    for i in range(s % n):
        answer[-i-1] += 1
    
    return answer
