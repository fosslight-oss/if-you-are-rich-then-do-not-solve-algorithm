'''
`두 원 사이의 정수 쌍` 문제와 유사
x^2 + y^2 = r^2
'''

def solution(gap, r):
    answer = 0

    for x in range(0, r + 1, gap):
        y = (r ** 2 - x ** 2) ** 0.5
        y_floor = int(y)
        answer += y_floor // gap + 1

    return answer