'''
.popleft()
.append(0)
두 개를 반복하면 될 듯

 --bridge--  <==  --truck_weights--
'''

from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    truck_weights = deque(truck_weights)
    bridge = deque([0] * bridge_length)
    sum_bridge = 0

    while True:
        if not truck_weights and sum_bridge == 0:
            break
        answer += 1
        sum_bridge -= bridge.popleft()

        # truck_weights가 남아있고, 무게 제한도 통과할 때
        if truck_weights and truck_weights[0] + sum_bridge <= weight:
            val = truck_weights.popleft()
            bridge.append(val)
            sum_bridge += val
            continue
        bridge.append(0)

    return answer