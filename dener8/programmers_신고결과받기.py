'''
한 번에 한 명의 유저 신고 가능
한 유저가 동일한 유저 신고 가능 but, 카운팅은 안됨

k번 신고되면 정지 -> 해당 유저를 신고한 모든 유저에게 정지 사실 발송

    key  -    value
신고받은사람 - 신고한사람

(1) defaultdict으로 중복 제거하고,
(2) k로 다시 거르기

'''
from collections import defaultdict


def solution(id_list, report, k):
    answer = []
    sue_dd = defaultdict(set)
    cnt_dd = {}
    for element in id_list:
        cnt_dd[element] = 0

        # 신고 중복 제거
    for i in range(len(report)):
        reporter, target = report[i].split()
        sue_dd[target].add(reporter)

    for key in sue_dd:
        reporters = sue_dd[key]
        if len(reporters) >= k:
            for reporter in reporters:
                cnt_dd[reporter] += 1

    for key in cnt_dd:
        answer.append(cnt_dd[key])

    return answer