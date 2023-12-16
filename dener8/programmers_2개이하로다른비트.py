def solution(numbers):
    answer = []

    for number in numbers:
        if number % 2 == 0:  # 짝수면
            answer.append(number + 1)

        else:  # 홀수면
            number = '0' + bin(number)[2:]
            idx = -1
            for i in range(len(number) - 1, -1, -1):
                if number[i] == '0':
                    idx = i
                    break
            number = list(number)
            number[idx] = '1'
            number[idx + 1] = '0'

            number = ''.join(number)
            number = int(number, 2)
            answer.append(number)

    return answer