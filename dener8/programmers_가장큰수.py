'''
처음 푼 방식 => 오답
'''
# def solution(numbers):
#     answer = ''

#     max_num = max(numbers)
#     max_length = len(str(max_num))
#     for i in range(len(numbers)):
#         numbers[i] = [int(str(numbers[i]) + str(numbers[i])[-1] * (max_length - len(str(numbers[i])))), len(str(numbers[i]))]
#     numbers = sorted(numbers, key = lambda x: [-x[0], x[1]])

#     for number in numbers:
#         answer += str(number[0])[ : number[1]]

#     answer = str(int(answer))

#     return answer

'''
두 번째 => 정답
'''

def solution(numbers):
    answer = ''
    numbers = sorted(numbers, key=lambda x: str(x) * 3, reverse=True)  # padding을 해서 정렬 (실제 값은 바뀌지 않음)

    if numbers[0] == 0:
        return '0'

    answer = ''.join(map(str, numbers))

    return answer