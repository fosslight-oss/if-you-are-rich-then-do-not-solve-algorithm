'''
높은 프렛 1개만 발생
'손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다고 한다'

각 줄마다 stack을 두고,
stack 최상단 기준으로
1. =
2. <
3. >
에 따라서 실행하면 됨
'''

stack = [[] for _ in range(7)]
n, p = map(int, input().split())
ans = 0
for i in range(n):
    string, fret = map(int, input().split())
    while True:
        if not stack[string]:
            stack[string].append(fret)
            ans += 1
            break
        if stack[string][-1] > fret:
            stack[string].pop()
            ans += 1
            continue
        elif stack[string][-1] == fret:
            break
        else:
            stack[string].append(fret)
            ans += 1
            break
print(ans)