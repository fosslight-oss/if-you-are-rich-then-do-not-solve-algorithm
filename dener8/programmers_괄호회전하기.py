'''
괄호의 쌍이 잘 맞아야 함
'''

def solution(s):
    answer = 0

    for i in range(len(s)):
        new = s[i:] + s[:i]
        stack = []
        for alpha in new:
            if not stack:
                stack.append(alpha)
                continue
            if (stack[-1] == '{' and alpha == '}') or (stack[-1] == '(' and alpha == ')') or stack[
                -1] == '[' and alpha == ']':
                stack.pop()
            else:
                stack.append(alpha)
        if not stack:
            answer += 1

    return answer