from itertools import permutations as pm


def solution(k, dungeons):
    idx = [i for i in range(len(dungeons))]

    answer = -1
    for order in pm(idx):
        k_val = k
        k_answer = 0

        for o_idx in order:
            mini_pirodo, use_pirodo = dungeons[o_idx]
            if k_val >= mini_pirodo:
                k_val -= use_pirodo
                k_answer += 1
        answer = max(answer, k_answer)

    return answer