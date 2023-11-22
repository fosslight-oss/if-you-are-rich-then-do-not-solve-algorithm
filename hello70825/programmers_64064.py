'''
불량 사용자 - 당첨 처리시 제외
아이디 일부 문자를 *로 가려서 전달함

user_id 크기가 8, banned_id 크기가 8이라 완전 탐색으로 구해도 될 듯
경우의 수 구하기

'''

ss = set()

def go(idx, banned, now):
    if idx == len(banned):
        now = sorted(list(set(now)))
        if len(now) != idx: return
        ss.add('-'.join(now))
        return
    for i in range(len(banned[idx])):
        now.append(banned[idx][i])
        go(idx+1, banned, now)
        now.pop()

def solution(user_id, banned_id):
    answer = 0
    
    banned = [[] for _ in range(len(banned_id))]
    idx = 0
    for ban in banned_id:
        for user in user_id:
            if len(ban) != len(user): continue
            flag = True
            for i in range(len(ban)):
                if ban[i] != '*' and ban[i] != user[i]:
                    flag = False
            if flag: banned[idx].append(user)
        idx += 1
    
    go(0, banned, [])
    
    return len(ss)
