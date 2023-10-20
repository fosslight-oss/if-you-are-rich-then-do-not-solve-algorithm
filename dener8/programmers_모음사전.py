'''
그냥 딕셔너리에 다 넣은 후에, 순서를 찾으면 되지 않을까

O(6 ** 6)
'''
from collections import defaultdict

dd = defaultdict(int)
arr = [' ', 'A', 'E', 'I', 'O', 'U']

def go(word, depth):
    global dd
    if depth == 5:  # 이 경우, dd에 값 넣어야 함
        result = ""
        for alpha in word:
            if alpha != ' ':
                result += alpha
        dd[result] += 1
        return

    for i in range(6):
        go(word + arr[i], depth + 1)


def solution(word):
    global dd
    answer = 0
    go("", 0)
    candi = sorted(list(dd.keys()))
    for i in range(len(candi)):
        if candi[i] == word:
            return i

    return answer