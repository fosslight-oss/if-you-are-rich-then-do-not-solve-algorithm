'''
[문제 설명]
n명으로 연속되는 적의 공격을 순서대로 막는 게임
- 처음에 n명의 병사를 가짐
- 매 라운드마다 enemy[i]명의 적 등장
- 남은 병사중 enemy[i]명만큼 소모하여 적을 막을 수 있음
- enemy[i]의 수가 현재 병사보다 많으면 게임 종료
- +) 무적권 스킬을 k번 사용하여 병사 사용 없이 한 라운드를 막을 수 있음

[풀이]
- heapq를 사용하여 적의 수 내림차순으로 저장하기 (이때 가장 앞에 있는 k개 원소는 무적권 스킬을 무조건 사용)
그러다가 n이 sum(enemy[0:i])보다 작은 경우에는 게임 종료
만약 k개를 모두 사용하게 된다면 hq[k-1] > (현재 적의 수)인지 확인해가며 계산하기

heappush(hq, i) 기본값은 오름차순으로 삽입
heappop(hq)는 맨 앞에 있는 원소를 가져옴 (값이 작은걸 가져와서 값이 큰 emeny[i]로 무적권 스킬을 사용하도록 해야함)
'''
from heapq import *

def solution(n, k, enemy):
    answer = 0
    hq = []
    for i in range(len(enemy)):
        if len(hq) < k:
            heappush(hq, enemy[i])
            answer += 1
            continue

        last_value = heappop(hq)

        if enemy[i] >= last_value:
            n -= last_value
            heappush(hq, enemy[i])
        else:
            n -= enemy[i]
            heappush(hq, last_value)

        if n < 0: break
        answer += 1

    return answer