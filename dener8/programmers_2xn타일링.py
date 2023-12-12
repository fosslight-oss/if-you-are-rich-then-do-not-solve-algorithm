'''
점화식 세우기
1 2 3 5 ..
'''

def solution(n):
    li = [1, 2]
    if n == 1:
        return 1
    if n == 2:
        return 2
    for i in range(2, n):
        li.append((li[i - 1] + li[i - 2]) % 1_000_000_007)

    return li[-1]