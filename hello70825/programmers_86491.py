def solution(sizes):
    for i in range(len(sizes)):
        sizes[i] = sorted(sizes[i])
    a, b = 0, 0
    for x, y in sizes:
        a = max(a, x)
        b = max(b, y)
    answer = a * b
    return answer
