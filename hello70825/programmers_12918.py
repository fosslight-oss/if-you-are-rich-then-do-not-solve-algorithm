def solution(s):
    answer = True
    if len(s) not in [4, 6]: answer = False
    for i in range(len(s)):
        if not('0' <= s[i] <= '9'):
            answer = False
    return answer
