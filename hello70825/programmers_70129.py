'''
1. x의 모든 0을 제거
2. x의 길이를 c라고 하면 x를 2진법으로 표현한 문자열로 변경

"1"이 나올 때까지 반복 -> 무조건 보장하나봄
'''

def solution(s):
    s = [*s]
    tr_cnt = 0
    eli_cnt = 0
    while 1:
        if s == ["1"]: break
        tmp = []
        for i in range(len(s)):
            if s[i] == '1': tmp.append(s[i])
            else: eli_cnt += 1
        num = ''.join(tmp)
        s = [*str(bin(len(num))[2:])]
        tr_cnt += 1
    answer = [tr_cnt, eli_cnt]
    return answer
