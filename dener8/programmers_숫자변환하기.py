'''
+n, *2, *3
1. 계속 queue에 후보군을 넣는다.
2. queue.popleft()해서 그 숫자가
        y보다 작으면 다시 1을 반복한다
        y와 같으면 그게 정답
        y보다 크면 아무일도 X => 초기값 -1을 끝까지 유지하면 결국 그게 y로 만들 수 없다는 뜻
'''
from collections import deque

def solution(x, y, n):
    answer = -1
    dq = deque()
    dq.append((x, 0))
    visited = set() # set을 사용하지 않으면 시간초과 발생. y에 맞는 빈 리스트를 생성해서 방문 체크를 하는 방법도 있음!
    while dq:
        num, cnt = dq.popleft()

        if num == y:
            return cnt
        elif num < y:
            if (num + n) not in visited:
                dq.append((num + n, cnt + 1))
                visited.add(num + n)
            if (num * 2) not in visited:
                dq.append((num * 2, cnt + 1))
                visited.add(num * 2)
            if (num * 3) not in visited:
                dq.append((num * 3, cnt + 1))
                visited.add(num * 3)

    return answer