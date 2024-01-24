'''
n: 벽 길이
m: 롤러 길이

`한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만
다시 칠하기로 정한 구역은 적어도 한 번 페인트칠을 해야 합니다.`
'''

def solution(n, m, section):
    answer = 1
    startWall = section[0]
    while section:
        if section[0] - startWall < m:  # 롤러가 다 품을 수 있는 영역이면
            section.pop(0)
        else:
            startWall = section[0]
            answer += 1

    return answer