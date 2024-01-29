'''
하나의 트리를 두 개로 분리하여 두 트리의 노드 수의 차이를 최소화하기
어떻게든 끊기게 주어짐

for i in range(n) -> node 하나씩 빼서 모든 경우의 트리 만들기

O((V+E) * N) => 통과 가능
'''
from collections import deque


def solution(n, wires):
    answer = float('inf')
    # 인접리스트
    # set에 계속 넣어서 길이가 1이면 return 0, 길이가 2이면 return 차의 절댓값
    for i in range(n - 1):
        new_wires = wires[:i] + wires[i + 1:]
        graph = [[] for _ in range(n + 1)]
        for nodeA, nodeB in new_wires:
            graph[nodeA].append(nodeB)
            graph[nodeB].append(nodeA)
        # graph 만든 후
        node_set = set()

        for j in range(1, n + 1):
            visited = [False] * (n + 1)
            dq = deque()
            dq.append(j)
            visited[j] = True
            cnt = 1
            while dq:
                parent = dq.popleft()
                for child in graph[parent]:
                    if not visited[child]:
                        dq.append(child)
                        visited[child] = True
                        cnt += 1
            node_set.add(cnt)
        node_list = list(node_set)
        if len(node_list) == 2:
            answer = min(answer, abs(node_list[0] - node_list[1]))
        else:
            answer = 0

    return answer