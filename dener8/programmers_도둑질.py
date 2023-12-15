'''
연속된 2개는 털 수 없음
단, [0]과 [-1] 도 연결되어 있기 때문에 털 수 없음

O...O 불가능
O...X 가능
X...O 가능

2개의 가능 값 중 최대값 return 하자
'''
def solution(money):
    # O...X
    must_first = [money[0], max(money[0], money[1])]
    for i in range(2, len(money) - 1):
        must_first.append(max(money[i] + must_first[i - 2], must_first[i - 1]))
    must_first.append(must_first[-1])

    # X...O
    must_last = [0, money[1]]
    for i in range(2, len(money)):
        must_last.append(max(money[i] + must_last[i - 2], must_last[i - 1]))

    answer = max(must_first[-1], must_last[-1])
    return answer