def solution(s):
    answer = ""
    words = {"one": 1, "two": 2, "three": 3, "four": 4, "five": 5,
             "six": 6, "seven": 7, "eight": 8, "nine": 9, "zero": 0}

    temp = ""
    for num in s:
        if num in "1234567890":
            answer += num
            continue
        temp += num
        if temp in words:
            answer += str(words[temp])
            temp = ""

    answer = int(answer)
    return answer