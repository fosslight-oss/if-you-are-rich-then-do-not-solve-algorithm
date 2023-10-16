'''
먹는 종류만 다양하게 만들기
[], [전체] -> 왼쪽으로 하나씩 이동하기
'''


def solution(topping):
    answer = 0

    chulsu_cake = [0] * 10002
    chulsu_count = 0
    brother_cake = [0] * 10002
    brother_count = 0

    for x in topping:
        if brother_cake[x] == 0:
            brother_count += 1
        brother_cake[x] += 1

    for x in topping:
        if chulsu_cake[x] == 0:
            chulsu_count += 1
        chulsu_cake[x] += 1

        brother_cake[x] -= 1
        if brother_cake[x] == 0:
            brother_count -= 1

        if chulsu_count == brother_count:
            answer += 1

    return answer