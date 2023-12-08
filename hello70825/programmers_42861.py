def find(parents, x):
    if parents[x] == x: return x
    return find(parents, parents[x])

def merge(parents, x, y):
    x, y = find(parents, x), find(parents, y)
    parents[max(x, y)] = min(x, y)

def solution(n, costs):
    parents = [i for i in range(n)]
    costs = sorted(costs, key=lambda x: x[2])

    answer = 0
    for x, y, cost in costs:
        if find(parents, x) != find(parents, y):
            merge(parents, x, y)
            answer += cost
    return answer
