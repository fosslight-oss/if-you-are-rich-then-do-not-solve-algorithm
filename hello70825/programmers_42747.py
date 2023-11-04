'''
논문 n편중, h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 = H-index
N = 1000
M = 10000
O(NM)으로도 풀림
'''

def solution(citations):
    answer = 0
    max_h = max(citations)
    for h in range(max_h, -1, -1):
        under_h = 0
        upper_h = 0
        for x in citations:
            if x >= h: upper_h += 1
            else: under_h += 1
        if under_h <= h and upper_h >= h:
            answer = h
            break
    return answer
