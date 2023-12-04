def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x: [x[1]])
    last = routes[0][1]
    for x, y in routes:
        if last < x:
            answer += 1
            last = y
    answer += 1
    return answer
