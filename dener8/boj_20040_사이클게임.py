'''
union(): find()를 이용해서 부모를 찾고, 결합하는 함수 = 부모를 동일하게 만들기
find(): 부모 찾기 함수

사이클이 완성되면 게임종료

'C에 속한 임의의 선분의 한 끝점에서 출발하여 모든 선분을 한 번씩만 지나서 출발점으로 되돌아올 수 있다.'
=> 유니온 파인드

연결하려는 두 점의 부모노드가 모두 같다면 "사이클 형성"
'''

# def find(x):
#     if x != parents[x]: # x가 최상위 부모노드가 아니라면
#         x = find(parents[x]) # 최상위 부모노드 아니니, 상위 부모노드를 인자로 집어넣어서 최상위 부모노드 찾으러 가기
#     return x

def find(x): # path compression 적용
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

def union(nodeA, nodeB):
    x = find(nodeA)
    y = find(nodeB)
    if x > y:
        parents[x] = y
    else:
        parents[y] = x

node_cnt, edge_cnt = map(int, input().split())
parents = [i for i in range(node_cnt)]
for i in range(edge_cnt):
    nodeA, nodeB = map(int, input().split())
    if find(nodeA) == find(nodeB): # 부모 노드가 같으면
        print(i + 1)
        exit()
    else:
        union(nodeA, nodeB)
print(0)