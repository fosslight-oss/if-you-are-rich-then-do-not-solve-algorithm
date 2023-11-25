'''
k: 최고점
m: 한 상자에 담기는 개수
'''

def solution(k, m, score):
    answer = 0
    score = sorted(score, reverse=True)
    for i in range(0, len(score), m):
        if len(score[i: i + m]) == m:
            answer += m * min(score[i: i + m])

    return answer