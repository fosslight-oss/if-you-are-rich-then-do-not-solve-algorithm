'''
ex.
    4 -> 2 -> 1
    7 -> 4 -> 2 -> 1

'''

def solution(n, a, b):
    answer = 0

    while a != b:
        answer += 1
        if not a % 2:  # 짝수
            a //= 2
        else:
            a = (a + 1) // 2

        if not b % 2:  # 짝수
            b //= 2
        else:
            b = (b + 1) // 2

    return answer