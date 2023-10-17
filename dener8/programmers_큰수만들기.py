'''
여러 개를 밀어내는 과정을 한 번에 다 하려고 하지 말고 한 번씩 생각하기
무조건 k개를 제거해야 함

- k == 0
    그냥 계속 넣는 수밖에 없음
- k != 0
    값을 비교하여 (1)빼고 넣든, (2)무시하든 해야함

    numbers가 모두 비면 종료
'''
from collections import deque

def solution(number, k):
    number = deque(list(map(int, number)))
    answer = []

    while number:
        pop_num = number.popleft()
        while k and answer and answer[-1] < pop_num:
            k -= 1
            answer.pop()

        answer.append(pop_num)

    while k:  # k가 남았을 때(= 숫자를 많이 까내지 못한 경우)를 고려해야 함
        answer.pop()
        k -= 1

    return ''.join(map(str, answer))