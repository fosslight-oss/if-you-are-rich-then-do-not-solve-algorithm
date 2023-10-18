'''
(arr1[0][0] * arr2[0][0]) + (arr1[0][1] * arr2[1][0]) + (arr1[0][2] * arr2[2][0])

(a x b) x (b x c) = (a x c)
arr1 행 선택 -> arr2 열 선택 -> ..
(1) 헷갈리니까 결과를 일차원 배열에 죄다 넣고,
(2) a x c 배열에 적절히 배치하기
'''
def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        for k in range(len(arr2[0])):
            temp = 0
            for j in range(len(arr2)):
                temp += arr1[i][j] * arr2[j][k]
            answer.append(temp)

    result = []
    length = len(arr2[0])
    for i in range(0, len(answer), length):
        result.append(answer[i : i + length])

    return result