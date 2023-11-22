'''
- 크레인으로 좌우 움직임
- 맨 위에 있는 인형 집을 수 있음
- 같은 인형이 두 개 연속 쌓이면 인형이 터짐
'''

def solution(board, moves):
    n = len(board)
    m = len(board[0])
    answer = 0
    
    stacks = [[] for _ in range(len(board[0]))]
    for j in range(m):
        for i in range(n-1, -1, -1):
            if board[i][j]:
                stacks[j].append(board[i][j])
    
    stack = []
    for move in moves:
        if stacks[move-1]:
            stack.append(stacks[move-1].pop())
        if len(stack) >= 2 and stack[-1] == stack[-2]:
            answer += 2
            stack.pop()
            stack.pop()
    
    return answer
