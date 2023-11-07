'''
[idx, val]의 순서
'''

def solution(numbers):
    answer = [0] * len(numbers)
    stack = []

    for idx in range(len(numbers)):
        if not stack or stack[-1][1] >= numbers[idx]:  # stack에 담아둬야 하는 경우
            stack.append([idx, numbers[idx]])  # [idx, val]
            continue

        # 해당 값이 뒷 큰수에 해당하는 경우
        val = numbers[idx]
        while stack and stack[-1][1] < val:  # `stack이 비지 않고, 뒷 큰수로 인해 없앨 수 있는 경우`에 지속
            answer[stack.pop()[0]] = val
        stack.append([idx, val])

    while stack:
        answer[stack.pop()[0]] = -1

    return answer