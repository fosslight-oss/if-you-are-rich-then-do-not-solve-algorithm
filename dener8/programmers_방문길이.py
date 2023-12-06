'''
출발점, 도착점 두 개의 요소를 비교하면 되지 않을까?
[(0, 0), (1, 0)] 이런식으로

'''
# U D R L
dx, dy = [0, 0, 1, -1], [1, -1, 0, 0]

def solution(dirs):
    answer = 0
    x, y = 0, 0
    move_list = []
    for dir in dirs:
        move = [(x, y)]
        if dir == 'U':
            if y < 5:
                y += 1
        elif dir == 'D':
            if y > -5:
                y -= 1
        elif dir == 'R':
            if x < 5:
                x += 1
        elif dir == 'L':
            if x > -5:
                x -= 1

        if move[0] != (x, y):
            move.append((x, y))
            move_list.append(sorted(move))

    move_list = sorted(move_list)
    for i in range(len(move_list) - 1):
        if move_list[i] != move_list[i + 1]:
            answer += 1
    answer += 1

    return answer