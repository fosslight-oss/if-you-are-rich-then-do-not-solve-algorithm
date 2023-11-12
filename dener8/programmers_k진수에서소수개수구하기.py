'''
n을 k진수로 바꾸기

(1) -> 방향으로 0P 찾기
(2) <- 방향으로 P0 찾기
(3) -> 방향으로 0P0 찾기 => 이건 근데 (1) or (2)에서도 잡아낼 수 있지 않나

그럼 밴다이어그램 생각하면서 (1) + (2) - (3) count하면 될 듯
'''

'''
위의 방법 다 필요없이 '0'으로 split하면 됨
'''

def isPrime(n): # 에라토스테네스 사용하지 않고 제곱근까지만 완전탐색
    for i in range(2, int(n ** (1/2)) + 1):
        if n % i == 0: # 나누어 떨어지는 수가 있음
            return False
    return True

def change(n, k):
    li = []
    while n:
        li.append(n % k)
        n //= k
    return ''.join(map(str, li[::-1]))

def solution(n, k):
    answer = 0
    n_str = change(n, k)
    li = n_str.split('0')
    print(li)
    for i in range(len(li)):
        if li[i] == '' or li[i] == '1':
            continue
        if isPrime(int(li[i])):
            answer += 1
    return answer