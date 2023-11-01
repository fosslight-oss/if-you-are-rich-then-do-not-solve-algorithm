'''
- K칸 점프 -> K만큼의 건전지 사용
- (현재까지 온 거리) * 2 순간이동 -> 건전지 줄지 않음
'''

def solution(n):
    ans = 0
    while n > 0:
        print(n)
        if n % 2 != 0:
            ans += 1
            n = (n - 1) // 2
        else:
            n = n // 2

    return ans