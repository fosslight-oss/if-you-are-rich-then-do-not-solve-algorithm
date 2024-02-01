'''
cards1과 cards2에는 서로 다른 단어만 존재합니다.
'''

def solution(cards1, cards2, goal):
    answer = ''
    n = len(cards1) + len(cards2)

    for _ in range(n):
        if not goal:
            return "Yes"
        if cards1 and cards1[0] == goal[0]:
            cards1.pop(0)
            goal.pop(0)
        elif cards2 and cards2[0] == goal[0]:
            cards2.pop(0)
            goal.pop(0)

    if not goal:
        return "Yes"
    return "No"