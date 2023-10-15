'''
종류가 많은 것부터 우선적으로 담아야 함
'''

def solution(k, tangerine):
    cnt = [0] * (max(tangerine) + 1)
    for i in tangerine:
        cnt[i] += 1
    cnt = sorted(cnt, reverse=True)

    answer = 0
    res = 0
    for i in range(len(cnt)):
        res += cnt[i]
        if res >= k:
            answer = i + 1
            break
    return answer