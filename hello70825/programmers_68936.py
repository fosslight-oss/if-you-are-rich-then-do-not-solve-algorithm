'''
행의 개수 1024 (2의제곱으로 늘어남)

재귀로 풀어도 되고, 스택으로 해도 될 듯

result = [x, y] 최종적으로 남는 0의 개수와 1의 개수
'''

def solution(arr):
    answer = [0, 0]
    stack = [arr]
    if len(arr) == 1:
        return [0, 1]
    zero, one = 0, 0
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            if arr[i][j]: one += 1
            else: zero += 1
    if one == 0: return [1, 0]
    elif zero == 0: return [0, 1]

    while 1:
        arr = stack.pop()
        n = len(arr)
        for x in range(2):
            for y in range(2):
                zero, one = 0, 0
                square = []
                for i in range(n // 2 * x, n // 2 * (x + 1)):
                    tmp = []
                    for j in range(n // 2 * y, n // 2 * (y + 1)):
                        tmp.append(arr[i][j])
                        if arr[i][j]: one += 1
                        else: zero += 1
                    square.append(tmp)
                if zero == 0: answer[1] += 1
                elif one == 0: answer[0] += 1
                else: stack.append(square)
        if not stack: break

    return answer
