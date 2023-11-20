'''
우선순위 세가지

dd를 두 개 두기
1. 장르별 총합 dd
2. 장르별 [재생횟수, idx] dd
'''

from collections import defaultdict

def solution(genres, plays):
    answer = []

    sum_dd = defaultdict(int)
    info_dd = defaultdict(list)

    for i in range(len(genres)):
        sum_dd[genres[i]] += plays[i]
        info_dd[genres[i]].append([plays[i], i])

    pairs = sorted(sum_dd.items(), key=lambda x: -x[1])
    sum_dd = []
    for key, value in pairs:
        sum_dd.append(key)
    print(sum_dd)
    # sum_dd = sorted(sum_dd, reverse = True)  ## 여기가 문제 => items() 활용해야 함
    for i in range(len(sum_dd)):
        genre = sum_dd[i]
        element_list = info_dd[genre]
        element_list = sorted(element_list, key=lambda x: [-x[0], x[1]])
        answer.append(element_list[0][1])
        if len(element_list) >= 2:
            answer.append(element_list[1][1])

    return answer