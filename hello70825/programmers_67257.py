'''
+, -, *를 사용하여 가장 큰 절대값 제출하기

6가지 경우의 수
+-*
-+*
-*+
*-+
+*-
*+-
'''

def plus(values):
    stack = []
    flag = False
    for x in values:
        if x == '+': flag = True
        elif flag:
            flag = False
            stack.append(stack.pop() + x)
        else: stack.append(x)
    return stack

def minus(values):
    stack = []
    flag = False
    for x in values:
        if x == '-': flag = True
        elif flag:
            flag = False
            stack.append(stack.pop() - x)
        else: stack.append(x)
    return stack

def multiple(values):
    stack = []
    flag = False
    for x in values:
        if x == '*': flag = True
        elif flag:
            flag = False
            stack.append(stack.pop() * x)
        else: stack.append(x)
    return stack

def solution(expression):
    answer = 0
    
    # 숫자랑 수식 분리
    arr = []
    val = ''
    for i in range(len(expression)):
        if expression[i] not in ['-', '+', '*']:
            val += expression[i]
        else:
            arr.append(int(val))
            val = ''
            arr.append(expression[i])
    else: arr.append(int(val))

    # 연산 적용
    # +, -, *
    answer = max(answer, abs(multiple(minus(plus(arr)))[0]))
    # -, +, *
    answer = max(answer, abs(multiple(plus(minus(arr)))[0]))
    # -*+
    answer = max(answer, abs(plus(multiple(minus(arr)))[0]))
    # *-+
    answer = max(answer, abs(plus(minus(multiple(arr)))[0]))
    # +*-
    answer = max(answer, abs(minus(multiple(plus(arr)))[0]))
    # *+-
    answer = max(answer, abs(minus(plus(multiple(arr)))[0]))
    
    return answer
