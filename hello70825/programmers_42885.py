'''
최대 2명이므로 2명씩 매칭되어서 구명보트를 탈 수 있게 함
투 포인터처럼 left, right로 시작하고, 2명이 못탄다면 무거운 사람을 구명보트에 타게하기
'''
def solution(people, limit):
    people.sort()
    
    left = 0
    right = len(people) - 1
    
    answer = 0
    while left < right:
        if people[left] + people[right] <= limit:
            answer += 1
            left += 1
            right -= 1
        else:
            answer += 1
            right -= 1
    if left == right:
        answer += 1
    
    return answer
