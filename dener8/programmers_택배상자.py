# 시간초과 코드 (deque 사용)
'''
# from collections import deque
def solution(order): # order == [4, 3, 1, 2, 5] # 정해진 순서
    cnt = 0
    # order = deque(order)
    stack = []
    idx = 0
    for box in range(1, len(order) + 1):
        if box == order[idx]:
            idx += 1
            cnt += 1
        else:
            stack.append(box)
        while stack:
            if stack[-1] == order[idx]:
                stack.pop()
                idx += 1
                cnt += 1
            else:
                break

    return cnt
'''

# 정답 코드 (list 사용)

from collections import deque
def solution(order): # order == [4, 3, 1, 2, 5] # 정해진 순서
    cnt = 0
    # order = deque(order)
    stack = []
    idx = 0
    for box in range(1, len(order) + 1):
        stack.append(box)
        while stack and stack[-1] == order[idx]:
                stack.pop()
                idx += 1
                cnt += 1

    return cnt


'''
그동안 deque이 list보다 모든 부분에서 우세한 줄 알았다..
list의 인덱스 접근은 O(1)인 반면에, deque은 O(N)이다

그러므로, 
요소의 삽입/삭제가 잦을 경우에는 deque을 사용하고,
인덱스 접근이 잦을 경우에는 list를 사용하자! 🫡
'''
