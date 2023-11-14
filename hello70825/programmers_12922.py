def solution(n):
    answer = []
    for i in range(n):
        answer.append('박' if i % 2 else '수')
    return ''.join(answer)
