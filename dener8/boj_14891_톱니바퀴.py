'''
A - B
극이 다르면 서로 반대방향으로 회전
극이 같으면 회전 X

2, 6 idx만 판단하면 됨
2 - 2,6 - 2,6 - 6
'''

li = [list('00000000')] + [list(input()) for _ in range(4)]
n = int(input())
orders = [list(map(int, input().split())) for _ in range(n)]

# idx 1, 2, 3, 4
for num, dir in orders:
    order = [[num, dir]]
    flag = True
    if num == 1:
        if li[num + 1][6] != li[num][2]:
            order.append([num + 1, dir * -1])
        else:
            flag = False
        if flag:
            if li[num + 2][6] != li[num + 1][2]:
                order.append([num + 2, dir])
            else:
                flag = False
        if flag:
            if li[num + 3][6] != li[num + 2][2]:
                order.append([num + 3, dir * -1])

    elif num == 2:
        if li[num - 1][2] != li[num][6]:
            order.append([num - 1, dir * -1])
        if li[num + 1][6] != li[num][2]:
            order.append([num + 1, dir * -1])
        else:
            flag = False
        if flag:
            if li[num + 2][6] != li[num + 1][2]:
                order.append([num + 2, dir])

    elif num == 3:
        if li[num - 1][2] != li[num][6]:
            order.append([num - 1, dir * -1])
        else:
            flag = False
        if li[num + 1][6] != li[num][2]:
            order.append([num + 1, dir * -1])
        if flag:
            if li[num - 1][6] != li[num - 2][2]:
                order.append([num - 2, dir])

    elif num == 4:
        if li[num][6] != li[num - 1][2]:
            order.append([num - 1, dir * -1])
        else:
            flag = False
        if flag:
            if li[num - 1][6] != li[num - 2][2]:
                order.append([num - 2, dir])
            else:
                flag = False
        if flag:
            if li[num - 2][6] != li[num - 3][2]:
                order.append([num - 3, dir * -1])

    # order[]에 담긴 명령들 모두 수행
    for odr in order:
        # odr[0] -> 톱니바퀴
        # odr[1] -> 회전방향
        if odr[1] == 1: # 시계방향
            li[odr[0]] = [li[odr[0]][7]] + li[odr[0]][:7]
        else:
            li[odr[0]] = li[odr[0]][1:] + [li[odr[0]][0]]

ans = 0
if li[1][0] == '1':
    ans += 1
if li[2][0] == '1':
    ans += 2
if li[3][0] == '1':
    ans += 4
if li[4][0] == '1':
    ans += 8

print(ans)
