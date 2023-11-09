'''
N개의 아파트 - 4g를 5g로 바꿀거임 (근데 범위 좁음)
4g → 5g 바꾸는건 포함 X
새로 설치하는거 최소로 만들기

몫과 나머지?

예제2. 1~6, 범위 6개 = 2개 필요, 12~16, 범위 5개 = 1개 필요 -> 답 3
오름차순으로 정렬해서 기지국이 아닌 범위 구하기
고려사항 - 기지국 범위가 서로 겹칠 수도 있음
'''

def solution(n, stations, w):
    answer = 0
    width = w * 2 + 1
    
    start = 1
    for center in stations:
        left, right = center - w, center + w
        if start < left:
            length = left - start
            answer += length // width + (1 if length % width else 0)
        start = right + 1 # start는 무조건 센터보다 작을 수 밖에 없어서 나머지 사항은 종료

    # 마지막 끝 부분 계산
    length = n - start + 1
    answer += length // width + (1 if length % width else 0)

    return answer
