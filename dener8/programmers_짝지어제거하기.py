def solution(s):
    answer = 1
    stack = []
    for alph in s:
        stack.append(alph)
        if len(stack) >= 2 and stack[-1] == stack[-2]:
            stack.pop()
            stack.pop()
    if stack:
        answer = 0

    return answer