'''
대기실 5개 (각 대기실은 5x5)

맨헤튼 거리 3 이상만 허용됨
(단, 서로의 장소로 이동할 수 없는 경우는 2도 허용)

P: 응시자가 앉아있는 자리
O: 빈 테이블
X: 파티션

4방향(상하좌우)를 2번 이동해서 값을 판단한다.
but, 첫 번째 방향의 반대 방향으로는 이동하면 안된다.
=> 그냥 16방향 모두 계산하여 경우의 수를 합한 후, 결과값에 -4 해줘도 될 듯
    (-4가 아닐 수도 있다. 첫 번째부터 막혀 있어서 이동 못할 수도 있으므로)
=> 개수 세는 게 아니고 True or False만 체크하는거다!!

결국, 2칸으로 갈 수 있으면 0
           갈 수 없으면 1

'''
from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]


def solution(places):
    answer = []
    for place in places:  # place == ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]
        dq = deque()
        flag = True
        for x in range(5):
            for y in range(5):
                if place[x][y] == 'P':
                    for k in range(4):
                        nx, ny = x + dx[k], y + dy[k]
                        if 0 <= nx < 5 and 0 <= ny < 5:
                            if place[nx][ny] == 'P':
                                flag = False
                            elif place[nx][ny] == 'O':
                                dq.append((nx, ny))
                    # 1단계 통과한 점들만 dq에 담기게 됨
                    while dq:
                        i, j = dq.popleft()
                        for k in range(4):
                            nx, ny = i + dx[k], j + dy[k]
                            if 0 <= nx < 5 and 0 <= ny < 5:
                                if nx == x and ny == y:
                                    continue
                                if place[nx][ny] == 'P':
                                    flag = False

        if flag:
            answer.append(1)
        else:
            answer.append(0)

    return answer