def solution(array, height):
    answer = sum(1 for x in array if height < x)
    return answer
