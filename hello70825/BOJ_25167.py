'''
- 1등 1점, 2등 2점, 3등 3점
- 빠르게 풀은 사람이 순위를 매김 (기준 = 해결한 시간 - 처음 틀렸을 때 시간)
  - 걸린 시간이 같을 때, 사전 순으로 빠른 사람이 정렬
  - 한 번에 정답을 맞춘다면 무효처리, 이후엔 (전체 인원수 + 1)만큼의 점수 부여
- 각 문제를 여러번 틀리고 해결하지 못했으면 전체 인원수만큼의 점수 부여
대회는 오전 10시부터 오후 9시 59분에 끝남 (10:00 ~ 21:59)

입력값의 제출기록은 제출한 순서대로
문제수 N, 사람수 M, 기록의 길이 P

그러면 각 유저마다 dfd로 관리하는게 좋아보임
dfd(user = dfd(1: [0(아직안풀음0/틀림1/해결2), 0(처음 틀린시간, 시*60+분), 0(맞춘 시간, 시*60+분)]))
dfd(user = 점수)
'''

input = __import__('sys').stdin.readline
from collections import defaultdict as dfd

n, m, p = map(int, input().split())
names = input().strip().split()

problem = [dfd(lambda: [0, 0, 0, 0]) for _ in range(n + 1)] # 풀은 상태, 처음 틀린 시간, 맞춘 시간, 무효 처리
solve_time = [[] for _ in range(n + 1)] # solve[문제번호] = [문제를 해결하는데 걸린 시간, 이름]
none_solve = dfd(lambda: []) # 이름: [무효 문제 번호...]

for i in range(p):
    idx, start_time, user, result = input().strip().split()

    idx = int(idx)
    hour, minute = map(int, start_time.split(':'))
    time = hour * 60 + minute

    if result == 'solve': # 맞은 경우
        if problem[idx][user][0] == 0 and problem[idx][user][1] == 0 and problem[idx][user][3] == 0: # 한 번에 맞춘 경우 처음엔 무효
            problem[idx][user][2] = time
            none_solve[user].append(idx)
            problem[idx][user][3] = 1
        elif problem[idx][user][0] == 0 and problem[idx][user][1] == 0 and problem[idx][user][3] == 1: # 무효한다음 다시 맞추면 중간에 틀려도 똑같은 점수 부여
            problem[idx][user][2] = time
        elif problem[idx][user][0] == 0 and problem[idx][user][1] != 0 and problem[idx][user][2] == 0 and problem[idx][user][3] == 0: # 한 번 틀리고 맞춘 경우
            wrong = problem[idx][user][1]
            problem[idx][user][2] = time
            solve = time
            solve_time[idx].append([solve - wrong, user])
    else: # 틀린 경우
        if problem[idx][user][1] == 0:
            problem[idx][user][1] = time
score_board = dfd(lambda: 0) # 점수

# 무효 점수부터 계산
for name in none_solve.keys():
    score_board[name] += (m + 1) * len(none_solve[name])

# 이후 실제 점수 계산
problem_score = [1] * (n + 1)
for i in range(1, n+1):
    problem_time = sorted(solve_time[i])
    for ignored, name in problem_time:
        score_board[name] += problem_score[i]
        problem_score[i] += 1


# 풀지 못한 점수 계산
for i in range(1, n+1):
    for name in names:
        if problem[i][name][3] == 1: continue
        if problem[i][name][0] == 0 and problem[i][name][1] != 0 and problem[i][name][2] == 0:
            # 틀린 시도 있는 사람은 (전체 인원 수) 점수 부여
            score_board[name] += m
        if problem[i][name][0] == 0 and problem[i][name][1] == 0 and problem[i][name][2] == 0:
            # 틀린 시도도 없는 사람은 (전체 인원 수 + 1) 점수 부여
            score_board[name] += (m + 1)

ans = sorted(score_board.keys(), key=lambda x: [score_board[x], x])
print('\n'.join(ans))
