def solution(want, number, discount):
    answer = 0
    li = []
    for i in range(len(number)):
        for k in range(number[i]):
            li.append(want[i])

    for i in range(len(discount) - len(li) + 1):
        if sorted(li) == sorted(discount[i: i + len(li)]):
            answer += 1

    return answer