from collections import deque, Counter


def solution(n, edge):
    answer = 0
    # graph 만들기
    graph = [[] for _ in range(n + 1)]
    for nodeA, nodeB in edge:
        graph[nodeA].append(nodeB)
        graph[nodeB].append(nodeA)
    visited = [False for _ in range(n + 1)]

    # 1번 node에서 탐색 시작
    dq = deque()
    dq.append((1, 0))  # node, cnt
    visited[1] = True
    cnt_list = []
    while dq:
        parent, cnt = dq.popleft()
        for child in graph[parent]:
            if not visited[child]:
                dq.append((child, cnt + 1))
                visited[child] = True
                cnt_list.append(cnt + 1)

    answer = Counter(cnt_list)

    return answer[max(cnt_list)]