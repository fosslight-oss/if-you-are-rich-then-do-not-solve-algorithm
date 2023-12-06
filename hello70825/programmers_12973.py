def solution(s):
    stack = []
    last = ''
    for i in range(len(s)):
        flag = False
        while stack:
            if stack[-1] == s[i]:
                stack.pop()
                flag = True
            else: break
        if not flag: stack.append(s[i])
    return 0 if stack else 1
