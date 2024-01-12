'''
기존에는 다익스트라라고 생각했는데,
크루스칼을 사용하는 MST(최소스패닝트리) 문제
'''

def find(x):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

def union(x, y):
    x = find(x)
    y = find(y)
    if x > y:
        parents[x] = y
    else:
        parents[y] = x

while True:
    node, edge = map(int, input().split())
    if node == 0 and edge == 0:
        break
    ans = 0 # 아낄 수 있는 값
    edge_info = [list(map(int, input().split())) for _ in range(edge)]
    edge_info = sorted(edge_info, key = lambda x: x[2]) # weight 기준 오름차순
    parents = [i for i in range(node)]
    for nodeA, nodeB, weight in edge_info:
        if find(nodeA) == find(nodeB): # 이미 부모가 같다면, 사이클 형성하게 됨 -> 막아야 함
            ans += weight # 연결을 안하는 것이 절약하는 것이므로, 여기서 더해줌
            continue
        else:
            union(nodeA, nodeB)
    print(ans)


