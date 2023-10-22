from collections import deque


def solution(s):
    q = deque()
    for x in s:
        q.append(x)

    answer = 0
    for i in range(len(s)):
        stack = []
        flag = True
        for j in range(len(s)):
            if q[j] in ["[", "(", "{"]:
                stack.append(q[j])
            elif stack:
                if (q[j] == "]" and stack[-1] == "[") or (q[j] == ")" and stack[-1] == "(") or q[j] == "}" and stack[
                    -1] == "{":
                    stack.pop()
                else:
                    flag = False
            else:
                flag = False
        if stack: flag = False
        if flag: answer += 1
        q.append(q.popleft())
    return answer