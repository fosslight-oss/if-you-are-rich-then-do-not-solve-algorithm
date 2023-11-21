'''
J(A, B) = 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값

다중집합의 경우
교집합은 적은 쪽 개수만큼, 합집합은 많은 쪽 개수만큼 추가해주면 됨

'''
from collections import defaultdict

def solution(str1, str2):
    answer = 0
    n_cnt = 0  # 교집합 cnt
    u_cnt = 0  # 합집합 cnt

    str1, str2 = str1.lower(), str2.lower()
    li1, li2 = [], []

    # 원소 거르기
    for i in range(len(str1) - 1):
        temp1 = str1[i: i + 2]
        flag1 = True
        for alpha in temp1:
            if not ('a' <= alpha <= 'z'):
                flag1 = False

        if flag1: li1.append(temp1)

    for i in range(len(str2) - 1):
        temp2 = str2[i: i + 2]
        flag2 = True
        for alpha in temp2:
            if not ('a' <= alpha <= 'z'):
                flag2 = False

        if flag2: li2.append(temp2)

    # dictionary 만들기
    dic1, dic2 = defaultdict(int), defaultdict(int)
    for i in range(len(li1)):
        dic1[li1[i]] += 1
    for i in range(len(li2)):
        dic2[li2[i]] += 1

    # 원소 비교하며 cnt (교, 합 개수 세기)
    # 합집합은 두 dic 다 돌아야하지만, 교집합은 1개의 dic만 돌면 됨
    for key in dic1:
        n_cnt += min(dic1[key], dic2[key])

    u_dic = defaultdict(int)
    for key in dic1:
        u_dic[key] = max(dic1[key], dic2[key])
    for key in dic2:
        u_dic[key] = max(dic1[key], dic2[key])
    for key in u_dic:
        u_cnt += u_dic[key]

    if u_cnt == 0:
        return 65536
    answer = int((n_cnt / u_cnt) * 65536)

    return answer