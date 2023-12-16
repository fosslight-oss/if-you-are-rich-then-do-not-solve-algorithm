'''
한 선수느 왼족에, 한 선수는 오른쪽에 음식 먹음
중앙에 물을 먹는 선수가 승리
'''

def solution(food):
    a = []
    b = []
    
    for i in range(1, len(food)):
        num = food[i] // 2
        for j in range(num):
            a.append(i)
            b.append(i)
    
    answer = ''.join(map(str, a)) + '0' + ''.join(map(str, b[::-1]))

    return answer
