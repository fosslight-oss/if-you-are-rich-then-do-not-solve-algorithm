'''
일단 넣고, 쌍이 맞으면 pop()을 두 번
'''

def solution(s):
    answer = True

    stack = []
    for i in range(len(s)):
        stack.append(s[i])

        if len(stack) >= 2 and stack[-1] == ')' and stack[-2] == '(':
            stack.pop()
            stack.pop()

    return not stack