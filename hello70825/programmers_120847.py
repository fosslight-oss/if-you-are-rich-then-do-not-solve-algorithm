def solution(numbers):
    sort_numbers = sorted(numbers)
    answer = sort_numbers[-1] * sort_numbers[-2]
    return answer
