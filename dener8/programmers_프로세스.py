'''
우선순위는 클수록 좋음!
location이 계속 바뀌기 때문에 잘 갱신해줘야함
=> popleft()로 값을 빼낼 경우 리스트의 길이가 변하기 때문에 idx 실수를 할 여지가 있음. 그냥 0으로 채우자

남은 우선순위들 중 자신보다 큰게 있으면 안됨
'''

from collections import deque

def zeroCounter(arr):
    cnt = 0
    for i in arr:
        if i == 0:
            cnt += 1
    return cnt


def solution(priorities, location):
    # answer = 0 # 다 더해주고 길이만큼 나눠주면 됨
    priorities = deque(priorities)

    while True:
        first_val = priorities[0]
        if first_val == max(priorities):
            # 리스트에서 0의 개수를 세면 그게 순위가 됨
            if location == 0:
                return zeroCounter(priorities) + 1
            priorities.popleft()
            priorities.append(0)

        else:
            priorities.append(priorities.popleft())

        # location 갱신
        location -= 1
        if location < 0:
            location += len(priorities)