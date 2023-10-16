'''
- data 정렬: 1순위 data의 col번째 값 기준 오름차순, 2순위 기본키 기준 내림차순
이후엔 row_begin ~ row_end까지 i번쨰 값을 나눈 나머지를 더하고, XOR 연산 진행
'''


def solution(data, col, row_begin, row_end):
    col -= 1
    row_begin -= 1
    row_end -= 1

    answer = 0
    data = sorted(data, key=lambda x: [x[col], -x[0]])

    for i in range(row_begin, row_end + 1):
        val = 0
        for j in range(len(data[i])):
            val += data[i][j] % (i + 1)
        answer ^= val

    return answer