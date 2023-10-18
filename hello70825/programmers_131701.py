'''
완탐?
O(LENGTH) * O(LENGTH) =O(길이1 ~ 길이1000 순회) * O(선택한 길이에 따라 슬라이딩 윈도우 진행)
숫자 합 저장은 set보다 최대합이 1,000,000이므로 배열로 설정하기
[7, 9, 1, 1, 4] = (7), (9), (1), (1), (4)
[7, 9, 1, 1, 4, 7]  = (7, 9), (9, 1), (1, 1), (1, 4), (4, 7)
'''

from collections import deque

MAX = 1000001


def solution(elements):
    result = [0] * MAX
    n = len(elements)

    for i in range(n):
        q = deque()
        val = 0
        for j in range(i + 1):
            val += elements[j]
            q.append(elements[j])
        result[val] += 1

        for j in range(i + 1, n + i):
            val -= q.popleft()
            q.append(elements[j])
            val += q[-1]
            result[val] += 1
        elements.append(elements[i])

    answer = sum(1 for i in range(MAX) if result[i])
    return answer