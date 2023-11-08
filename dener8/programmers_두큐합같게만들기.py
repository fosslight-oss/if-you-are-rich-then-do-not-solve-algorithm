'''
길이가 같은 두 개의 큐
300_000이니까 그냥 완전탐색 해도 됨

불가능한 경우 -1 return
=> 이걸 큐가 그냥 그대로 바뀐 경우로 판단해도 되나?

'''
from collections import deque


def solution(queue1, queue2):
    queue1, queue2 = deque(queue1), deque(queue2)

    # queue1_copy = queue1.copy()
    # queue2_copy = queue2.copy() # 복사해두고, queue가 서로 바뀌어버리면 while문 종료할 예정

    cnt = 0
    popcnt1, popcnt2 = 0, 0
    length = len(queue1)
    sum_queue1 = sum(queue1)
    sum_queue2 = sum(queue2)

    while True:
        # if queue1 == queue2_copy and queue2 == queue1_copy: # 근데 매번 확인하면 시간 터지는거 아닌가
        if cnt > length * 3:
            return -1

        if sum_queue1 == sum_queue2:
            return cnt
        elif sum_queue1 > sum_queue2:
            val = queue1.popleft()
            queue2.append(val)
            sum_queue2 += val
            sum_queue1 -= val
            popcnt1 += 1
            cnt += 1
        else:
            val = queue2.popleft()
            queue1.append(val)
            sum_queue1 += val
            sum_queue2 -= val
            popcnt2 += 1
            cnt += 1

    return answer