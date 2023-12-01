'''
x, y를 모두 저장해놨다가,
min(x) ~ max(x) * min(y) * max(y) 구하면 될 듯
but, min_val == max_val인 경우에는 이차원이 만들어지지 않으므로 예외처리
'''

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0] # 북쪽 방향에서 시작 # idx 커지면 R 회전

n = int(input())
for _ in range(n):
    orders = input()
    x, y, dir = 0, 0, 0 # dir 0, 1, 2, 3 => 북, 동, 남, 서
    x_list = [0]
    y_list = [0]
    for order in orders:
        if order == 'L':
            if dir == 0:
                dir = 3
            else:
                dir -= 1
        elif order == 'R':
            if dir == 3:
                dir = 0
            else:
                dir += 1
        elif order == 'F':
            x += dx[dir]
            y += dy[dir]
            x_list.append(x)
            y_list.append(y)
        elif order == 'B':
            x -= dx[dir]
            y -= dy[dir]
            x_list.append(x)
            y_list.append(y)

    width, height = max(x_list) - min(x_list), max(y_list) - min(y_list)
    print(width * height)
