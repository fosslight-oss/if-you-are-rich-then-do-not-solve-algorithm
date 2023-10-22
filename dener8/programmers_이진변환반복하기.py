'''
`s`이라는 String이 계속 while문에 돌 수 있도록
'''

def toBinary(num):
    remain = []
    while num:
        remain.append(num % 2)
        num //= 2

    return ''.join(map(str, remain[::-1]))


def solution(s):
    cnt = [0, 0]  # [회전 횟수, 버린 0의 개수]

    while s != '1':  # s는 시작과 끝에서는 반드시 str으로 변환할 것
        no_zero = []
        for i in range(len(s)):  # 1. '0' 걷어내기
            if s[i] == '1':
                no_zero.append(s[i])
            else:
                cnt[1] += 1
        cnt[0] += 1
        s = toBinary(len(no_zero))

    return cnt