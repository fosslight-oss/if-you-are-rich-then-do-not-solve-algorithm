'''
N 빌딩 개수 <= 80_000
오른쪽에서 자신 이상의 높이면, 그 이후로 전부 못봄

완전탐색 = 1 + 2 + ... + 80_000 => 시간초과
그렇다면?

모두 stack에 쌓음

하락세면 계속 쌓이기만 하지만, 
처음으로 stack[-1]보다 큰 값이 등장한다면 stack을 파고 내려가는 작업 시작
stack에서 빠지는 값들은 그 즉시 업데이트. 더 이상 파고 들어가지 못하면, stack에 적재
'''
n = int(input())
buildings = [int(input()) for _ in range(n)]
marking = [0] * n
stack = []
for i in range(n):
    idx, val = i, buildings[i]
    # if not stack:
    #     stack.append([idx, val])
    #     continue

    # stack에 값이 있는 경우
    while stack:
        top_idx, top_val = stack[-1]
        if top_val <= val:
            stack.pop()
            marking[top_idx] = idx - top_idx - 1
        else:
            break
    # stack이 비었거나, 위에서 break된 경우
    stack.append([idx, val])

# stack이 아직 비워지지 않았을 때
while stack:
    idx = stack.pop()[0]
    marking[idx] = n - idx - 1

print(sum(marking))