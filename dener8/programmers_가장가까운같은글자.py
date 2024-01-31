'''
딕셔너리에 알파벳별로 인덱스 저장하기
'''
from collections import defaultdict

def solution(s):
    answer = []
    dd = defaultdict(lambda: -1)

    for idx, alpha in enumerate(s):
        if dd[alpha] != -1:
            answer.append(idx - dd[alpha])
        else:
            answer.append(-1)
        dd[alpha] = idx

    return answer