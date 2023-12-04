def solution(bandage, health, attacks):
    answer = health
    idx = 0
    heal = 0
    for i in range(1001):
        if i == attacks[idx][0]:
            answer -= attacks[idx][1]
            idx += 1
            heal = 0
            if answer <= 0:
                return -1
        elif answer < health:
            answer = min(health, answer + bandage[1])
            heal += 1
            if heal == bandage[0]:
                answer = min(health, answer + bandage[2])
                heal = 0
        if idx == len(attacks): break
    return answer
