def solution(s, n):
    answer = ''

    for ele in s:
        if 'A' <= ele <= 'Z':
            if chr(ord(ele) + n) > 'Z':
                answer += chr(ord(ele) + n - 26)
            else:
                answer += chr(ord(ele) + n)
        elif ord('a') <= ord(ele) <= ord('z'):
            if chr(ord(ele) + n) > 'z':
                answer += chr(ord(ele) + n - 26)
            else:
                answer += chr(ord(ele) + n)
        else:
            answer += ele

    return answer