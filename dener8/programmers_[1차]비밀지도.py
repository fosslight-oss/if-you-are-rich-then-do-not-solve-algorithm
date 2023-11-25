'''
둘 다 공백이어야 공백, 그 외에는 벽
'''
def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        x, y = bin(arr1[i])[2:], bin(arr2[i])[2:]
        if len(x) < n:
            x = '0' * (n - len(x)) + x
        if len(y) < n:
            y = '0' * (n - len(y)) + y

        line = ""
        for j in range(len(x)):
            if x[j] == '0' and y[j] == '0':
                line += " "
            else:
                line += "#"
        answer.append(line)

    return answer