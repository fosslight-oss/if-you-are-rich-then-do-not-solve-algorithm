'''
10일동안 회원 자격 부여
매일 1개 제품 할인 (하루에 1개씩만 구매 가능)
자신이 원하는 제품과 수량이 10일 연속 일치할 때 회원가입할거임
dfd
'''
from collections import defaultdict as dfd


def solution(want, number, discount):
    dd = dfd(lambda: 0)
    answer = 0

    for i in range(10):
        dd[discount[i]] += 1
    flag = True
    for i in range(len(want)):
        if dd[want[i]] != number[i]:
            flag = False
    if flag: answer += 1
    for i in range(10, len(discount)):
        dd[discount[i - 10]] -= 1
        dd[discount[i]] += 1
        flag = True
        for i in range(len(want)):
            if dd[want[i]] != number[i]:
                flag = False
        if flag: answer += 1
    return answer