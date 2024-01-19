def solution(name, yearning, photos):
    answer = []
    dictionary = dict()
    for i in range(len(name)):
        dictionary[name[i]] = yearning[i]
    for photo in photos:
        score = 0
        for person in photo:
            if person in dictionary:
                score += dictionary[person]
        answer.append(score)

    return answer

