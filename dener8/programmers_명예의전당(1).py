'''
명예의 전당 중 꼴찌가 '발표 점수'
'''

def solution(k, scores):
    answer = []

    honors = []
    for score in scores:
        if len(honors) < k:
            honors.append(score)
            honors.sort()
            answer.append(honors[0])
            continue
        # 명예의 전당 판단
        honors.sort()
        if honors[0] < score:
            honors = honors[1:] + [score]
            honors.sort()
        answer.append(honors[0])

    return answer