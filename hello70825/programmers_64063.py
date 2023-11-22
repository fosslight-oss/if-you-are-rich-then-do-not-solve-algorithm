'''
방 k개
1. 원하는 방이 비어있으면 배정
2. 원하는 방이 비어있지 않으면 원하는 방보다 번호가 크면서 비어있는 방중 가장 번호가 작은 방

'''
from collections import defaultdict as dfd

def solution(k, room_number):
    answer = []
    
    dd = dfd(lambda : -1)
    for x in room_number:
        if dd[x] == -1:
            answer.append(x)
            nxt = x+1
            while dd[nxt] != -1:
                nxt = dd[nxt]
            dd[x] = nxt
        else:
            nxt = x
            while dd[nxt] != -1:
                nxt = dd[nxt]
            answer.append(nxt)
            nnxt = nxt + 1
            while dd[nnxt] != -1:
                nnxt = dd[nnxt]
            dd[nxt] = nnxt
    return answer
