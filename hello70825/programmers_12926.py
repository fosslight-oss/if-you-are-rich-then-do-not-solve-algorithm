def solution(s, n):
    answer = ''
    for i in range(len(s)):
        if s[i] == ' ':
            answer += s[i]
            continue
        if s[i].isupper(): answer += chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        else: answer += chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    return answer
