'''
그냥 나눗셈, 뺄셈만 잘하면 됨
return [번호, 차례]
'''

def solution(n, words):
    answer = []
    used = [words[0]]
    words = ["fake"] + words
    person, turn = 0, 0
    for idx in range(2, len(words)):
        if words[idx][0] != words[idx - 1][-1] or words[idx] in used:
            person = idx % n
            if not person:
                person = n
            turn = (idx - 1) // n + 1
            return [person, turn]
        used.append(words[idx])

    return [person, turn]