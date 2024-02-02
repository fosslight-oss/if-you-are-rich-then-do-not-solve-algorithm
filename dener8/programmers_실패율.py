'''
도달 O & 클리어 X / 도달 O & 클리어 O

N: 전체 스테이지 수
stages: 각 사용자가 멈춰있는 스테이지

'''
from collections import defaultdict


def solution(N, stages):
    answer = []
    dd = defaultdict(int)

    # 1 2 2 2 3 3 4 6
    for stage in stages:
        dd[stage] += 1
    sumVal = len(stages)
    for stage in range(1, N + 1):
        if sumVal == 0:
            answer.append([0, stage])
            continue
        answer.append([dd[stage] / sumVal, stage])  # [실패율, stage]
        sumVal -= dd[stage]

    answer = sorted(answer, key=lambda x: [-x[0], x[1]])

    res = []
    for li in answer:
        res.append(li[1])

    return res