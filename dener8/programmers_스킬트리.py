def solution(skill, skill_trees):
    answer = 0
    for i in range(len(skill_trees)):
        temp = ""
        for j in skill_trees[i]:
            if j in skill:
                temp += j

        if temp == skill[:len(temp)]:
            answer += 1

    return answer