'''
뒤에서부터 확인하기
ex) a1, a2, a3, a4, ...가 있을 때
1) 가장 마지막 원소는 무조건 -1
2) a1 < a2라면 a1의 뒷큰수는 a2
3) a1 >= a2라면 while문을 통해 a1 < ax가 나오는 뒷큰수가 나올 때까지 반복. 중간에 -1이 나오면 -1로 하고 중단
'''

def solution(numbers):
    answer_idx = [-1] * len(numbers)
    for i in range(len(numbers) - 1, -1, -1):
        if i == len(numbers) - 1: answer_idx[i] = -1
        elif numbers[i] < numbers[i + 1]: answer_idx[i] = i + 1
        else:
            idx = answer_idx[i + 1]
            while idx != -1:
                if numbers[i] < numbers[idx]: break
                idx = answer_idx[idx]
            answer_idx[i] = idx

    answer = []
    for idx in answer_idx:
        if idx == -1: answer.append(-1)
        else: answer.append(numbers[idx])
    return answer