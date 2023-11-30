'''
x-4
    +, - 에 따라 판단

단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
'''

from collections import defaultdict


def solution(survey, choices):
    answer = ''

    dd = defaultdict(int)

    for idx in range(len(survey)):
        if choices[idx] - 4 > 0:
            dd[survey[idx][1]] += choices[idx] - 4
        else:
            dd[survey[idx][0]] -= choices[idx] - 4

    if dd['R'] >= dd['T']:
        answer += 'R'
    else:
        answer += 'T'

    if dd['C'] >= dd['F']:
        answer += 'C'
    else:
        answer += 'F'

    if dd['J'] >= dd['M']:
        answer += 'J'
    else:
        answer += 'M'

    if dd['A'] >= dd['N']:
        answer += 'A'
    else:
        answer += 'N'

    return answer