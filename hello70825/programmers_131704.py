'''
1번 상자부터 n번 상자까지 번호가 증가하는 순서대로 컨테이너 벨트에 일렬로 놓여 영재에게 전달
순서대로 상자를 내릴 수 있음
보조 컨테이너 벨트는 스택으로 돌아감

[1, 2, 3, 4, 5]

[1, 2, 3] - {4}
[1, 2] - {4, 3}
1) 스택에 있는 마지막 값이 빼야하는 값이면 뺴는 것을 택함
2) 더 이상 스택에 있는 값을 다 뺐으면 다음 컨베이너 벨트 값을 넣을지 말지 결정
2) 다음 컨베이너 벨트 값을 못가져가면 그 값은 스택에 넣고 반복

'''

def solution(order):
    answer = 0
    stack = []
    idx = 0
    for i in range(1, len(order) + 1):
        while stack:
            if stack[-1] == order[idx]:
                stack.pop()
                idx += 1
                answer += 1
            else:
                break
        if order[idx] == i:
            idx += 1
            answer += 1
        else:
            stack.append(i)
    else:
        while stack:
            if stack[-1] == order[idx]:
                stack.pop()
                idx += 1
                answer += 1
            else:
                break

    return answer