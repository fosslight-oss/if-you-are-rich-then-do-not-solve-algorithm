'''
n x n
0: 빈 칸
1: 집
2: 치킨집

치킨 거리 == " 가장 가까운 치킨집까지의 거리 "
임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.

n: n x n
m: 최대 치킨집 개수
return 치킨거리의 총 합

최단거리 -> bfs
'''

from itertools import combinations as cb
import sys

n, m = map(int, input().split())
li = []
for _ in range(n):
    li.append(list(map(int, input().split())))

houses = []
chickens = []
for i in range(n):
    for j in range(n):
        if li[i][j] == 1:
            houses.append((i, j))
        elif li[i][j] == 2:
            chickens.append((i, j))

ans = sys.maxsize
for chicken_set in cb(chickens, m): # 치킨집 고르고,
    dist_sum = 0
    # 고른 치킨집들에 대해 거리 계산
    for house in houses:
        dist = 2500
        for chicken in chicken_set:
            dist = min(dist, abs(house[0] - chicken[0]) + abs(house[1] - chicken[1]))
        dist_sum += dist
    ans = min(ans, dist_sum)

print(ans)