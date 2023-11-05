def solution(s):
    answer = ''
    for i in range(len(s)):
        if i == 0:
            if ord('a') <= ord(s[i]) <= ord('z'):
                answer += chr(ord(s[i]) - 32)
            else:
                answer += s[i]
            continue
        if s[i - 1] == ' ' and ord('a') <= ord(s[i]) <= ord('z'):
            answer += chr(ord(s[i]) - 32)
        elif s[i - 1] != ' ' and ord('A') <= ord(s[i]) <= ord('Z'):
            answer += chr(ord(s[i]) + 32)
        else:
            answer += s[i]

    return answer