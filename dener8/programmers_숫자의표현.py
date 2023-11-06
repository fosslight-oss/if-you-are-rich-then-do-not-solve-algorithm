def solution(n):
    answer = 0
    numbers = [i for i in range(1, 10001)]
    for i in range(len(numbers)):
        temp_sum = numbers[i]
        for j in range(i + 1, len(numbers) + 1):
            if temp_sum == n:
                answer += 1
                # print(numbers[i : j])
                break
            elif temp_sum > n:
                break
            temp_sum += numbers[j]
    return answer