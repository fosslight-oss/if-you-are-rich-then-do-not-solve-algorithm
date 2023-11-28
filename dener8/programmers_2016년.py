def solution(a, b):
    days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    dic = {1: "FRI", 2: "SAT", 3: "SUN", 4: "MON", 5: "TUE", 6: "WED", 0: "THU"}
    cnt = sum(days[: a - 1]) + b
    answer = dic[cnt % 7]

    return answer