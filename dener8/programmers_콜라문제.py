'''
a병 -> b병
'3병 -> 2병' 이런 상황이 있을 수 있음
'''

def solution(a, b, n):
    answer = 0

    while n >= a:
        get = (n // a) * b
        left = n % a
        answer += get
        n = get + left

    return answer
