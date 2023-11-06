def solution(n):
    answer = 0
    arr = [0] * 2001
    arr[0] = 1; arr[1] = 1; arr[2] = 2
    for i in range(3, 2001):
        arr[i] = (arr[i-1] + arr[i-2]) % 1234567
    return arr[n]
