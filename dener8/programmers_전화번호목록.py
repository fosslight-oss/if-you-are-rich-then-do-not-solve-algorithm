'''
한 번호가 다른 번호의 접두어인 경우가 있는지 확인

접두어 있으면 false
없으면 true

완전탐색은 무조건 시간초과 (len(phone_number) == 1_000_000)
'''


def solution(phone_book):
    num_set = set()
    for num in phone_book:
        num_set.add(num)
    for num in phone_book:
        temp = ""
        for i in range(len(num)):
            temp += num[i]
            if temp in num_set and temp != num:
                return False
    return True