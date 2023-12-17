'''
return: 1 ~ 8 혹은 -1 (9 이상)
'''

def solution(N, number):
    dp = []

    for cnt in range(1, 9):  # 1 ~ 8 모두 확인하기
        cnt_set = set()  # 해당 cnt 개수로 만들 수 있는 숫자 집합
        cnt_set.add(int(str(N) * cnt))
        for i in range(0, cnt - 1):  # dp[] 길이만큼
            for x in dp[i]:
                for y in dp[-i - 1]:
                    cnt_set.add(x + y)
                    cnt_set.add(abs(x - y))
                    cnt_set.add(x * y)
                    if y != 0:
                        cnt_set.add(x // y)
        if number in cnt_set:
            return cnt
        dp.append(cnt_set)

    return -1