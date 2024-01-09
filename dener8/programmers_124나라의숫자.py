'''
1, 2, 4로만 구성
ans += "1" or "2" or "4"
이 후에 뒤집에서 return
'''

def solution(n):
    answer = ''

    while n:  # 조정 필요
        if n % 3 == 0:
            answer += '4'
        elif n % 3 == 1:
            answer += '1'
        elif n % 3 == 2:
            answer += '2'
        n = (n - 1) // 3

    return answer[::-1]