def solution(num_list):
    answer = [sum(1 for x in num_list if x % 2 == 0), sum(1 for x in num_list if x % 2)]
    return answer
