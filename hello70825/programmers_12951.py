def solution(s):
    blank_flag = True

    answer = []
    for i in range(len(s)):
        if s[i] == ' ':
            blank_flag = True
            answer.append(s[i])
        elif s[i] != ' ' and blank_flag:
            answer.append(s[i].upper())
            blank_flag = False
        else:
            answer.append(s[i].lower())
    return ''.join(answer)
